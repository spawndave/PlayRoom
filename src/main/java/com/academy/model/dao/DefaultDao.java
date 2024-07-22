package com.academy.model.dao;

import java.util.List;

public interface DefaultDao<T> {
    void createOrUpdate(T entity);
    T findById(int id);
    List<T> findAll();
}
