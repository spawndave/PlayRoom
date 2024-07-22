package com.academy.model.service;

import com.academy.model.dao.RoomDao;
import com.academy.model.dao.UserDao;
import com.academy.model.dao.impl.RoomDaoImpl;
import com.academy.model.dao.impl.UserDaoImpl;
import com.academy.model.entity.AgeGroup;
import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;

import java.util.List;

public class RoomService {

    public Room prepareRoom(int totalSum, AgeGroup ageGroup){
        ToyService toyService = new ToyService();
        RoomDao roomDao = new RoomDaoImpl();
        UserDao userDao = new UserDaoImpl();
        Room room = new Room(totalSum, ageGroup);
        room.setTotalSum(totalSum);
        room.setUsers(userDao.findAllByAge(room.getAgeGroup().getAge()));
        room.setToys(toyService.selectToysInRoomByPrice(room));
        roomDao.createOrUpdate(room);
        return room;
    }

    public List<Toy> findToysInRoomByPrice(Room room, double price){
        ToyService toyService = new ToyService();
        return toyService.filterToysByPriceInRoom(room.getToys(), price);
    }

    public AgeGroup getAgeGroup(int age){
        RoomDao roomDao = new RoomDaoImpl();
        return roomDao.getAgeGroup(age);
    }
}
