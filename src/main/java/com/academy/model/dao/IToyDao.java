package com.academy.model.dao;

import com.academy.model.entity.User;

import java.util.List;

public interface IUserDao extends IDefaultDao<User> {
    void create(User user);
    void update(User user);
    void delete(User user);
    User findById(int id);
    List<User> findAll();
}
