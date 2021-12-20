package com.hyan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author yanhanf
 * @ClassName PurchaserApplicationStarter
 * @Description TODO
 * @Date 2021/11/23
 */
@SpringBootApplication
public class PurchaserApplicationStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PurchaserApplicationStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PurchaserApplicationStarter.class);
    }
}
