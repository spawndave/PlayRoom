package com.academy.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Visitor {
    @Id
    private Long userId;
    @Id
    private Long room_id;
}
