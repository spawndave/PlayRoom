package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.ToyDao;
import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToyDaoImpl implements ToyDao {

    @Override
    public List<Toy> findToysByAge(int age) {
        String sql = "SELECT toy.id, toy.price, toy.description, toy.size_id, toy.age_group_id FROM play_room.toy " +
                "LEFT JOIN play_room.size ON play_room.toy.size_id = play_room.size.id " +
                "LEFT JOIN play_room.agegroup ON play_room.toy.age_group_id = play_room.agegroup.id " +
                "AND play_room.agegroup.age <= ?";
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, age);
            ResultSet resultSet = statement.executeQuery();
            List<Toy> toys = new ArrayList<>();
            while (resultSet.next()) {
                Toy toy = new Toy();
                toy.setId(resultSet.getInt("id"));
                toy.setPrice(resultSet.getFloat("price"));
                toy.setDescription(resultSet.getString("description"));
                toy.setSizeId(resultSet.getInt("size_id"));
                toy.setAgeGroupId(resultSet.getInt("age_group_id"));
                toys.add(toy);
            }
            return toys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    @Override
    public void createOrUpdate(Toy entity) {

    }

    @Override
    public Toy findById(int id) {
        return null;
    }

    @Override
    public List<Toy> findAll() {
        return List.of();
    }

}
