package com.academy.model.service;

import com.academy.model.dao.IToyDao;
import com.academy.model.dao.impl.ToyDaoImpl;
import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ToyService {

    public List<Toy> sortToysByPrice(List<Toy> toys){
        Toy[] toysCopy = toys.toArray(new Toy[0]);
        Arrays.sort(toysCopy, Comparator.comparingDouble(Toy::getPrice).reversed());
        return Arrays.asList(toysCopy);
    }

    public List<Toy> sortToysBySize(List<Toy> toys){
        Toy[] toysCopy = toys.toArray(new Toy[0]);
        Arrays.sort(toysCopy, Comparator.comparingLong(Toy::getSizeId));
        return Arrays.asList(toysCopy);
    }

    public List<Toy> selectToysInRoomByPrice(Room room){
        IToyDao toyDao = new ToyDaoImpl();
        List<Toy> toys = sortToysByPrice(toyDao.findToysByAge(room.getAgeGroup().getAge()));
        return toyDao.getBestVariant(room.getTotalSum(), toys, new ArrayList<Toy>());
    }

    public List<Toy> filterToysByPriceInRoom(List<Toy> toys, double price){
        return toys.stream().filter(toy-> toy.getPrice() <= price).collect(Collectors.toList());
    }
}
