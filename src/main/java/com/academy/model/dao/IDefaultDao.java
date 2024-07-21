package com.academy.model.dao;

import java.util.List;

public interface IDefaultDao<T> {
    void createOrUpdate(T entity);
    T findById(int id);
    List<T> findAll();
}
