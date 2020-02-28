package com.botwy.LetsEat.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Cuisine {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private String value;

    @JsonIgnore
    @ManyToMany(mappedBy = "cuisines")
    private Collection<Restaurant> restaurants;
}
