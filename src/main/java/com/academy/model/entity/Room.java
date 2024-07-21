package com.academy.model.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private long id;
    private String description;
    private AgeGroup ageGroup;
    private double totalSum;
    private List<Toy> toys = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Room(int totalSum, AgeGroup ageGroup) {
        this.totalSum = totalSum;
        this.ageGroup = ageGroup;
    }
}
