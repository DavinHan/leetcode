package com.example.service;

import com.example.MyHello;
import com.example.config.HelloApplicationInfoManager;
import com.example.config.HelloBasicModules;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * TODO
 *
 * @author yanhanf
 */
public class SayHello {

    //SPI
//    public static void main(String[] args) {
//        ServiceLoader<MyHello> serviceLoader = ServiceLoader.load(MyHello.class);
////        for (MyHello myHello : serviceLoader) {
////            myHello.sayHello();
////        }
//
//        Iterator<MyHello> iterator = serviceLoader.iterator();
//        while (iterator.hasNext()) {
//            MyHello next = iterator.next();
//            next.sayHello();
//        }
//    }


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new HelloBasicModules());
        HelloApplicationInfoManager instance = injector.getInstance(HelloApplicationInfoManager.class);
        instance.myHello1.sayHello();
        instance.myHello2.sayHello();
    }
}
