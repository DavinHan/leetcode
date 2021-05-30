package com.javassist.builder;

import javassist.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJavassistBuilder {


    private final static ClassPool classPool = ClassPool.getDefault();

    /**
     * 参考https://www.cnblogs.com/rickiyang/p/11336268.html
     */
    public static CtClass createClass() {
        // 1. 新建一个空类
        CtClass ctClass = classPool.makeClass("com.javassist.demo.Person");

        // 2. 新增字段
        // 字段名为name
        CtField field = null;
        try {
            field = new CtField(classPool.get("java.lang.String"), "name", ctClass);
            field.setModifiers(Modifier.PRIVATE);
            ctClass.addField(field, CtField.Initializer.constant("Mike"));
        } catch (CannotCompileException | NotFoundException e) {
            e.printStackTrace();
            return null;
        }

        // 3. 生成Setter 和 Getter
        try {
            ctClass.addMethod(CtNewMethod.setter("setName", field));
            ctClass.addMethod(CtNewMethod.getter("getName", field));
        } catch (CannotCompileException e) {
            e.printStackTrace();
            return null;
        }

        // 4. 生成无参构造方法
        CtConstructor noneConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        try {
            noneConstructor.setBody("{name = \"Jike\";}");
            ctClass.addConstructor(noneConstructor);
        } catch (CannotCompileException e) {
            e.printStackTrace();
            return null;
        }

        // 5. 生成有参构造方法
        try {
            CtConstructor allConstructor = new CtConstructor(new CtClass[]{classPool.get("java.lang.String")}, ctClass);
            // $0=this / $1,$2,$3... 代表方法参数
            allConstructor.setBody("{$0.name = $1;}");
            ctClass.addConstructor(allConstructor);
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
            return null;
        }

        // 6.  创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printObject", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        try {
            ctMethod.setBody("{" +
                    "try {" +
                    "System.out.println($0.name);" +
                    "} catch (Exception e) {" +
                    "e.printStackTrace();" +
                    "}" +
                    "}");
            ctClass.addMethod(ctMethod);
        } catch (CannotCompileException e) {
            e.printStackTrace();
            return null;
        }

        // 7. 将这个创建的类对象编译为.class文件
        try {
            ctClass.writeFile(".\\leetcode-training\\src\\main\\java\\");
        } catch (CannotCompileException | IOException e) {
            e.printStackTrace();
        }
        return ctClass;
    }

    public static void main(String[] args) {
//        CtClass aClass = createClass();
//
//        // 执行
//        assert aClass != null;
//        executeClass0(aClass, "Maryean");


//        executeClass1();


        updatePersonClass();

    }

    // 反射
    public static void executeClass0(CtClass aClass, String name){
        try {
            Object person = aClass.toClass().newInstance();
            Method setName = person.getClass().getMethod("setName", String.class);
            setName.invoke(person, name);
            Method printObject = person.getClass().getMethod("printObject");
            printObject.invoke(person);
        } catch (InstantiationException | IllegalAccessException | CannotCompileException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            aClass.detach();
        }
    }

    // .class 文件
    public static void executeClass1(){
        try {
            classPool.appendClassPath(".\\leetcode-training\\src\\main\\java\\");
            CtClass aClass = classPool.get("com.javassist.demo.Person");
            executeClass0(aClass, "Jacksonc");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updatePersonClass(){
        try {
            classPool.appendClassPath(".\\leetcode-training\\src\\main\\java\\");
            CtClass cc = classPool.get("com.javassist.demo.Person");

            CtMethod method = cc.getDeclaredMethod("printObject");

            method.insertBefore("System.out.println(\"before invoke\");");
            method.insertAfter("System.out.println(\"after invoke\");");

            // 新增一个方法
            CtMethod ctMethod = new CtMethod(CtClass.voidType, "getCurrentTime", new CtClass[]{}, cc);
            ctMethod.setModifiers(Modifier.PUBLIC);
            ctMethod.setBody("{System.out.println(System.currentTimeMillis());}");
            cc.addMethod(ctMethod);

            method.insertAt(30, "System.out.println(System.currentTimeMillis());");

            Object person = cc.toClass().newInstance();
            Method printObject = person.getClass().getMethod("printObject");
            Method getCurrentTime = person.getClass().getMethod("getCurrentTime");
            printObject.invoke(person);
            getCurrentTime.invoke(person);

            // 写会
            cc.writeFile(".\\leetcode-training\\src\\main\\java\\");
        } catch (NotFoundException | CannotCompileException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | IOException e) {
            e.printStackTrace();
        }
    }
}
