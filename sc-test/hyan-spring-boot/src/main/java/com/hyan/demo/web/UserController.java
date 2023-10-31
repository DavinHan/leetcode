package com.hyan.demo.web;

import com.hyan.demo.entity.User;
import com.hyan.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "查询全部用户")
    @GetMapping("/user")
    public List<User> findAll() {
        return service.findAll();
    }
}
