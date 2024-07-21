package com.academy.model.dao;

import com.academy.model.entity.AgeGroup;

import java.util.List;

public interface IAgeGroupDao extends IDefaultDao<AgeGroup> {
    void create(AgeGroup user);
    void update(AgeGroup user);
    void delete(AgeGroup user);
    AgeGroup findById(int id);
    List<AgeGroup> findAll();
}
