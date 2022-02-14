package com.hyan.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TODO
 *
 * @author yanhanf
 */
@Configuration
@PropertySource(value = "classpath:tomiy.properties")
@ConfigurationProperties(prefix = "com.hyan")
public class Tom {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
