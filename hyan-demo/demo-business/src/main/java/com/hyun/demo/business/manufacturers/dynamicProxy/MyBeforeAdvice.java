package com.hyun.demo.business.manufacturers.dynamicProxy;

import org.springframework.aop.BeforeAdvice;

public class MyBeforeAdvice implements BeforeAdvice {
    public void exec(){
        System.out.println("前置执行");
    }
}
