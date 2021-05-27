package com.agent.staticlly;

import com.agent.staticlly.method.MethodTimeConsuming;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;

public class MyAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.printf("java-agent1 : agentArgs is %s, inst is %s", agentArgs, inst.toString());

//        inst.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
//            System.out.println("loader is " + loader.toString());
//            System.out.println("className is " + className);
//            System.out.println("classBeingRedefined is " + classBeingRedefined.toString());
//            System.out.println("protectionDomain is " + protectionDomain.toString());
//            System.out.println("classfileBuffer is " + Arrays.toString(classfileBuffer));
//            return classfileBuffer;
//        });

        // VM Option is : -javaagent:D:\gitProject\test\leetcode-training\target\my-agent.jar=com.agent.demo.HelloWorld.mockTimeConsuming
        // 获取方法限定名
        MethodTimeConsuming.add(agentArgs);
        inst.addTransformer(new MethodTimeConsuming());
    }

    public static void premain(String agentArgs) {
        System.out.printf("java-agent2 : agentArgs is %s", agentArgs);
    }

}
