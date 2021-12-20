package com.hyan.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 厂商启动类
 *
 * @author yanhanf
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ManufacturesApplicationStarter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ManufacturesApplicationStarter.class)
                .run(args);
    }
}
