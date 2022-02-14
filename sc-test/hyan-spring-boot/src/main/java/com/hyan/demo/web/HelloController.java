package com.hyan.demo.web;

import com.hyan.demo.entity.Student;
import com.hyan.demo.entity.Tom;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private Tom tom;

    @ApiOperation(value = "根", notes = "根")
    @GetMapping("/index")
    public String index(){
        return "hello spring";
    }

    @ApiOperation(value = "查询学生1")
    @GetMapping("/student1")
    public String student1(){
        return name + ":" + age;
    }

    @ApiOperation(value = "查询学生2")
    @GetMapping("/student2")
    public String student2(){
        return student.toString();
    }
}
