package com.academy.model.dao;

import com.academy.model.entity.Toy;
import com.academy.model.entity.User;

import java.util.List;

public interface IToyDao extends IDefaultDao<Toy> {
    List<Toy> findToysByAge(int age);
    List<Toy> getBestVariant(double sum, List<Toy> toyList, List<Toy> newToyList);
}
