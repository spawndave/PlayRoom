package com.academy.model.dao;

import com.academy.model.entity.AgeGroup;
import com.academy.model.entity.Room;
import com.academy.model.entity.User;

import java.util.List;

public interface IRoomDao extends IDefaultDao<Room> {
    AgeGroup getAgeGroup(int age);
}
