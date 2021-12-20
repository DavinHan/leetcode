package com.hyun.demo.business.manufacturers.dynamicProxy;

import com.hyun.demo.business.manufacturers.proxy.InvocationHandlerProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyDynamicProxy <T> {

    private static final AtomicBoolean isBeforeAdvice = new AtomicBoolean(true);

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
        // 寻找JoinPoint连接点，AOP框架使用元数据定义
        if (isBeforeAdvice.get()) {
            (new MyBeforeAdvice()).exec();
        }
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }

    public static void main(String[] args) {
        // 1. 定义一个subject
        Subject subject = new RealSubject();
        // 2. 定义一个handler
        InvocationHandler handler = new InvocationHandlerProxy(subject);
        // 3. 定义主题的代理
        Subject proxy1 = null;
        Subject proxy2 = null;
        Subject proxy3 = null;
        Subject proxy4 = null;
        Subject proxy5 = null;
        try {
            proxy1 = MyDynamicProxy.newProxyInstance(Subject.class.getClassLoader(), Subject.class.getInterfaces(), handler);
        } catch (ClassCastException ignored){}
        try {
            proxy2 = MyDynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), Subject.class.getInterfaces(), handler);
        }catch (ClassCastException ignored){}
        try {
            proxy3 = MyDynamicProxy.newProxyInstance(Subject.class.getClassLoader(), subject.getClass().getInterfaces(), handler);
        }catch (ClassCastException ignored){}
        try {
            proxy4 = MyDynamicProxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        }catch (ClassCastException ignored){}
        try {
            proxy5 = MyDynamicProxy.newProxyInstance(MyDynamicProxy.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        }catch (ClassCastException ignored){}
        // 4. 代理的行为
        if (proxy1 != null) {
            proxy1.doSomething("aaa1");
        }
        if (proxy2 != null) {
            proxy2.doSomething("aaa2");
        }
        if (proxy3 != null) {
            proxy3.doSomething("aaa3");
        }
        if (proxy4 != null) {
            proxy4.doSomething("aaa4");
        }
        if (proxy5 != null) {
            proxy5.doSomething("aaa5");
        }
    }
}
