package com.academy.model.entity;

import lombok.Data;

@Data
public class Toy {
    private long id;
    private long ageGroupId;
    private long sizeId;
    private float price;
    private String description;
}
