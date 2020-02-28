package com.botwy.LetsEat.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Cuisine {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private String value;
}
