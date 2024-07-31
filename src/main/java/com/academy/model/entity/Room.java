package com.academy.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Room extends ModifierOptions{
    @Id
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn (name = "age_group_id")
    private AgeGroup ageGroup;
    @Column (name ="total_sum")
    private double totalSum;
    @ManyToMany
    @JoinTable(
            name = "room_toy",
            joinColumns = {
                    @JoinColumn(name ="room_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "toy_id")
            }

    )
    private List<Toy> toys = new ArrayList<>();

    //private List<User> users = new ArrayList<>();

}
