package com.academy.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SelectBeforeUpdate;

@Data
@Entity
//@DynamicUpdate
@Immutable
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(updatable = false, insertable = false)
    private float price;
    @Column(name = "age_group_id")
    @Access(AccessType.FIELD)
    private long ageGroupId;
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "size_id")
    private Size size;
    @Formula("Concat( id, price)")
    private String description;
    @Transient
    private Integer discount;
}
