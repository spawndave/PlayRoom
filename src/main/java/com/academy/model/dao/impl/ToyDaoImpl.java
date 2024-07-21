package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.IToyDao;
import com.academy.model.entity.Toy;
import com.academy.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToyDaoImpl implements IToyDao {

    @Override
    public List<Toy> findToysByAge(int age) {
        String sql = "SELECT toy.id, toy.price, toy.description, toy.size_id, toy.age_group_id FROM play_room.toy " +
                "LEFT JOIN play_room.size ON play_room.toy.size_id = play_room.size.id " +
                "LEFT JOIN play_room.agegroup ON play_room.toy.age_group_id = play_room.agegroup.id " +
                "AND play_room.agegroup.age <= ?";
        try(PreparedStatement statement = getPreparedStatement(sql)) {
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
    public List<Toy> getBestVariant(double sum, List<Toy> toyList, List<Toy> newToyList){
        for (int i=0; i < toyList.size(); i++) {
            Toy toy = toyList.get(i);
            if(sum >= toy.getPrice()){
                newToyList.add(toy);
                getBestVariant(sum - toy.getPrice(), toyList, newToyList);
                break;
            }
        }
        return newToyList;
    }

    private static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement;
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
