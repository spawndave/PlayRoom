package com.academy.model.dao.impl;

import com.academy.model.dao.RoomDao;
import com.academy.model.entity.Room;

public class RoomDaoImpl extends DefaultDaoIml<Room> implements RoomDao {
    public RoomDaoImpl() {
        super(Room.class);
    }
}
