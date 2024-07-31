package com.academy.model.service;

import com.academy.model.dao.ToyDao;
import com.academy.model.dao.impl.ToyDaoImpl;
import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;

import java.util.*;
import java.util.stream.Collectors;

public class ToyService {

    public List<Toy> sortToysByPrice(List<Toy> toys){
        Toy[] toysCopy = toys.toArray(new Toy[0]);
        Arrays.sort(toysCopy, Comparator.comparingDouble(Toy::getPrice).reversed());
        return Arrays.asList(toysCopy);
    }

    public List<Toy> sortToysBySize(List<Toy> toys){
        Toy[] toysCopy = toys.toArray(new Toy[0]);
        Arrays.sort(toysCopy, Comparator.comparingLong(toy-> toy.getSize().getId()));
        return Arrays.asList(toysCopy);
    }

    public List<Toy> selectToysInRoomByPrice(Room room){
        ToyDao toyDao = new ToyDaoImpl();
        List<Toy> toys = sortToysByPrice(toyDao.findToysByAge(room.getAgeGroup().getAge()));
        return toyDao.getBestVariant(room, toys, new ArrayList<Toy>());
    }

    public List<Toy> filterToysByPriceInRoom(List<Toy> toys, double price){
        return toys.stream().filter(toy-> toy.getPrice() <= price).collect(Collectors.toList());
    }
}
