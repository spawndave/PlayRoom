package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.RoomDao;
import com.academy.model.entity.AgeGroup;
import com.academy.model.entity.Room;
import com.academy.model.entity.Toy;
import com.academy.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public void createOrUpdate(Room room) {
        String insertRoomSql = "INSERT INTO `play_room`.`room` (`age_group_id`, `total_sum`, `description`) VALUES (?, ?, ?);";
        String selectSql = "SELECT MAX(id) AS `id` from `play_room`.`room`;";
        String insertVisitorSql = "INSERT INTO `play_room`.`visitor` (`user_id`, `room_id`) VALUES (?, ?);";
        String insertToySql = "INSERT INTO `play_room`.`room_toy` (`room_id`, `toy_id`) VALUES (?, ?);";

        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement statementInsertRoom = connection.prepareStatement(insertRoomSql);
            PreparedStatement statementSelect = connection.prepareStatement(selectSql);
            PreparedStatement statementUser = connection.prepareStatement(insertVisitorSql);
            PreparedStatement statementToy = connection.prepareStatement(insertToySql)
        ) {
            connection.setAutoCommit(false);

            statementInsertRoom.setInt(1, Long.valueOf(room.getAgeGroup().getId()).intValue());
            statementInsertRoom.setFloat(2, (float) room.getTotalSum());
            statementInsertRoom.setString(3, room.getDescription());
            statementInsertRoom.execute();

            ResultSet resultSet = statementSelect.executeQuery();
            if(resultSet.next()) {
                room.setId(resultSet.getInt("id"));
            }

            for (User user: room.getUsers()) {
                statementUser.setInt(1, Long.valueOf(user.getId()).intValue());
                statementUser.setInt(2, Long.valueOf(room.getId()).intValue());
                statementUser.execute();
            }

            for (Toy toy: room.getToys()) {
                statementToy.setInt(1, Long.valueOf(room.getId()).intValue());
                statementToy.setInt(2, Long.valueOf(toy.getId()).intValue());
                statementToy.execute();
            }

            resultSet.close();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AgeGroup getAgeGroup(int age){
        AgeGroup ageGroup = new AgeGroup();
        String selectSql = "SELECT * FROM agegroup WHERE age >=? ORDER BY age ASC LIMIT 1";
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(selectSql);
        ) {
            statement.setInt(1, age);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                ageGroup.setId(resultSet.getInt("id"));
                ageGroup.setAge(resultSet.getInt("age"));
                ageGroup.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ageGroup;
    }

    @Override
    public Room findById(int id) {
        return null;
    }

    @Override
    public List<Room> findAll() {
        return List.of();
    }
}
