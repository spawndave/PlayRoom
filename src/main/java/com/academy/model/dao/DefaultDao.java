package com.academy.model.dao;

import com.academy.model.entity.User;

import java.util.List;

public interface DefaultDao<T> {
    void createOrUpdate(T entity);
    void delete(T entity);
    <T> T findById(Integer id, Class<T> type);
}
