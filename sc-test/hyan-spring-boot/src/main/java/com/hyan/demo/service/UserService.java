package com.hyan.demo.service;

import com.hyan.demo.dao.UserDao;
import com.hyan.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
