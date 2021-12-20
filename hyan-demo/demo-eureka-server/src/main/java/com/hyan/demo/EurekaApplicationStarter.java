package com.hyan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka-server启动类
 *
 * @author yanhanf
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationStarter.class, args);
    }
}
