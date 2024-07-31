package com.academy.model.dao.impl;

import com.academy.model.dao.ToyDao;
import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;

import java.util.List;

public class ToyDaoImpl extends DefaultDaoIml<Toy> implements ToyDao {

    public ToyDaoImpl() {
        super(Toy.class);
    }

    @Override
    public List<Toy> findToysByAge(int age) {
        return List.of();
    }

    @Override
    public List<Toy> getBestVariant(Room room, List<Toy> toyList, List<Toy> newToyList){
        toyList.forEach(toy -> {
                    if(room.getTotalSum() >= toy.getPrice()){
                        newToyList.add(toy);
                        room.setTotalSum(room.getTotalSum() - toy.getPrice());
                        getBestVariant(room, toyList, newToyList);
                    }
                });
        return newToyList;
    }


}
