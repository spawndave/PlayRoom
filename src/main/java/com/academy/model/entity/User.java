package com.academy.model.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User extends ModifierOptions{
    @Id
    private Long id;
    private String name;
    private int age;
    @Embedded
    private DocData docData;

}
