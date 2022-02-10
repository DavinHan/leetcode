package com.hyan.demo.web;

import com.hyan.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author yanhanf
 */
@RestController
@EnableConfigurationProperties({Student.class})
public class HelloController {

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private int age;

    @Autowired
    private Student student;

    @GetMapping("/index")
    public String index(){
        return "hello spring";
    }

    @GetMapping("/student1")
    public String student1(){
        return name + ":" + age;
    }

    @GetMapping("/student2")
    public String student2(){
        return student.toString();
    }
}
