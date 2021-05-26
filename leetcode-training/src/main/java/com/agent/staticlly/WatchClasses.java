package com.agent.staticlly;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.Arrays;

public class WatchClasses {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.printf("java-agent1 : agentArgs is %s, inst is %s", agentArgs, inst.toString());

        inst.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
            System.out.println("loader is " + loader.toString());
            System.out.println("className is " + className);
            System.out.println("classBeingRedefined is " + classBeingRedefined.toString());
            System.out.println("protectionDomain is " + protectionDomain.toString());
            System.out.println("classfileBuffer is " + Arrays.toString(classfileBuffer));
            return classfileBuffer;
        });
    }

    public static void premain(String agentArgs) {
        System.out.printf("java-agent2 : agentArgs is %s", agentArgs);
    }

}
