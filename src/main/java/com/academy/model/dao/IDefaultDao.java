package com.academy.model.dao.impl;

import java.util.List;

public interface IDefaultDao<T> {
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(int id);
    List<T> findAll();
}
