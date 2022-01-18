package com.example.config;

import com.example.MyHello;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * TODO
 *
 * @author yanhanf
 */
@Singleton
public class HelloApplicationInfoManager {

    @Inject
    @Named("myHello1")
    public MyHello myHello1;

    @Inject
    @Named("myHello2")
    public MyHello myHello2;
}
