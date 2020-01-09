package com.botwy.LetsEat.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Value
@Builder
public class RestaurantDTO {
    @NonNull
    private long id;

    @NonNull
    private String name;

    @NonNull
    private double latitude;

    @NonNull
    private double longitude;

    private String address;

    private String postalCode;

    private String city;

    private String state;

    private String imageURL;

    private String[] cuisines;

    private int starNumber;
}
