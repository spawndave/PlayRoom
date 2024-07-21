package com.academy.controller;

import com.academy.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
