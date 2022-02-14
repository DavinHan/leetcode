package com.hyan.demo.web;

import com.hyan.demo.entity.User;
import com.hyan.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author yanhanf
 */
@RestController
public class UserController {

    @Resource
    private UserService service;

    @GetMapping("/user")
    public List<User> findAll() {
        return service.findAll();
    }
}
