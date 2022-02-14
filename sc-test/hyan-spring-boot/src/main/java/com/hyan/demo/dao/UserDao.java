package com.hyan.demo.dao;

import com.hyan.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author yanhanf
 */
public interface UserDao extends JpaRepository<User, Long> {
}
