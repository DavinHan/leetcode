package com.hyan.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author yanhanf
 */
@SpringBootApplication
public class RpcDemoApplicationStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RpcDemoApplicationStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}
