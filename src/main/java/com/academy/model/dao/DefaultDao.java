package com.academy.model.dao;

public interface DefaultDao<T> {
    void createOrUpdate(T entity);
    void delete(T entity);
    T findById(Integer id);
}
