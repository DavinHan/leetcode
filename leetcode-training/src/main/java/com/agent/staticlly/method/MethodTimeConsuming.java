package com.agent.staticlly.method;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodTimeConsuming implements ClassFileTransformer {

    // className : [methodNames]
    private static final Map<String, List<String>> monitorMethodMap = new HashMap<>();

    public static Map<String, List<String>> getMonitorMethodMap() {
        return monitorMethodMap;
    }

    public static void add(String methodAbs) {
        int pos = methodAbs.lastIndexOf(".");
        String className = methodAbs.substring(0, pos);
        String methodName = methodAbs.substring(pos + 1);
        List<String> methodLists = monitorMethodMap.get(className);
        if(methodLists == null || methodLists.size() == 0) {
            methodLists = new ArrayList<>();
            methodLists.add(methodName);
            monitorMethodMap.put(className, methodLists);
        } else {
            if(!methodLists.contains(methodName)) {
                methodLists.add(methodName);
            }
        }
    }


    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        // 判断加载的类是不是需要监控的类
        if(monitorMethodMap.containsKey(className)) {
            CtClass ctClass = null;
            try {
                // 使用 javassist，通过完全限定名获得 字节码类
                ctClass = ClassPool.getDefault().get(className);
                for (String method : monitorMethodMap.get(className)) {
                    // 得到方法的实例
                    CtMethod ctMethod = ctClass.getDeclaredMethod(method);
                    //创建一个新的方法
                    String newMethodName = method + "$new";
                    ctMethod.setName(newMethodName);
                    // 复用原来的方法
                    CtMethod newMethod = CtNewMethod.copy(ctMethod, method, ctClass, null);

                    // 构建新的方法体
                    String methodBodyStr = "{" +
                            "\nlong startTime = System.currentTimeMillis();\n" +
                            newMethodName + "($$);\n" +// 调用原有代码，类似于method();($$)表示所有的参数
                            "\nlong endTime = System.currentTimeMillis();\n" +
                            "\nSystem.out.println(\"监控信息(执行耗时)：" + className + "." + method + " => \" +(endTime - startTime) +\"毫秒\");" +
                            "}";
                    newMethod.setBody(methodBodyStr);// 替换新方法
                    ctClass.addMethod(newMethod);         // 增加新方法
                }
                return ctClass.toBytecode();
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
