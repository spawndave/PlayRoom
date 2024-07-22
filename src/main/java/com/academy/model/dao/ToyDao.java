package com.academy.model.dao;

import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;

import java.util.List;

public interface ToyDao extends DefaultDao<Toy> {
    List<Toy> findToysByAge(int age);
    List<Toy> getBestVariant(Room room, List<Toy> toyList, List<Toy> newToyList);
}
