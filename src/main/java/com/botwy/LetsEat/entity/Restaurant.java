package com.botwy.LetsEat.entity;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Restaurant {
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
