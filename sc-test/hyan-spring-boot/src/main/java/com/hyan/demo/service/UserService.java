package com.hyan.demo.service;

import com.hyan.demo.dao.UserDao;
import com.hyan.demo.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author yanhanf
 */
@Service
public class UserService {

    @Resource
    private UserDao dao;

    public List<User> findAll() {
        return dao.findAll();
    }
}
