package com.academy.model.dao;

import com.academy.model.entity.User;

import java.util.List;

public interface UserDao extends DefaultDao<User> {
    List<User> findAll();
    List<User> findAllByAge(int age);

}
