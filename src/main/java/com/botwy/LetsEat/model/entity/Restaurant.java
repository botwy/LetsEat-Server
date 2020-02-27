package com.botwy.LetsEat.model.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Restaurant {
    @Id
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String address;

    private String postalCode;

    private String city;

    private String state;

    private String imageURL;

    @OneToMany
    private Collection<Cuisine> cuisines;

    private int starNumber;
}
