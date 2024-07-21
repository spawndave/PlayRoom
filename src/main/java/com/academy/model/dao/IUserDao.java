package com.academy.model.dao;

import com.academy.model.entity.User;

import java.util.List;

public interface IUserDao extends IDefaultDao<User> {
    List<User> findAllByAge(int age);
}
