package com.botwy.LetsEat.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "area", "country", "phone", "price", "reserve_url", "mobile_reserve_url" })
public class RestaurantStub {
    @NonNull
    private long id;

    @NonNull
    private String name;

    @NonNull
    @JsonProperty("lat")
    private double latitude;

    @NonNull
    @JsonProperty("long")
    private double longitude;

    private String address;

    @JsonProperty("postal_code")
    private String postalCode;

    private String city;

    private String state;

    @JsonProperty("image_url")
    private String imageURL;

    private String[] cuisines;

    private int starNumber;
}
