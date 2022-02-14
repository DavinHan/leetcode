package com.hyan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO
 *
 * @author yanhanf
 */
@EnableSwagger2
@SpringBootApplication
public class SpringBootHyanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHyanApplication.class, args);
    }
}
