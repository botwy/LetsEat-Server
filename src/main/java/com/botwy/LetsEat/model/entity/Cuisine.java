package com.botwy.LetsEat.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Cuisine {
    @Id
    private long UUID;

    private String name;
}
