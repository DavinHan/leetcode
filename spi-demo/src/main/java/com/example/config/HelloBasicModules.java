package com.example.config;

import com.example.MyHello;
import com.example.service.Impl.MyHelloImpl1;
import com.example.service.Impl.MyHelloImpl2;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * TODO
 *
 * @author yanhanf
 */
public class HelloBasicModules extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(MyHello.class).annotatedWith(Names.named("myHello1")).to(MyHelloImpl1.class);
        this.bind(MyHello.class).annotatedWith(Names.named("myHello2")).to(MyHelloImpl2.class);
    }
}
