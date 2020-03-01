package com.botwy.LetsEat.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String address;

    private String postalCode;

    private String city;

    private String state;

    private String imageURL;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_cuisines",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id")
    )
    private Collection<Cuisine> cuisines;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private Collection<Review> reviews = new ArrayList<>();
}
