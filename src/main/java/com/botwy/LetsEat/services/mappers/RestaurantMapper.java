package com.botwy.LetsEat.services.mappers;

import com.botwy.LetsEat.services.dto.RestaurantDTO;
import com.botwy.LetsEat.services.dto.RestaurantStub;

public class RestaurantMapper {
    public RestaurantDTO fromStub(RestaurantStub restaurantStub) {
        return RestaurantDTO.builder()
                .id(restaurantStub.getId())
                .name(restaurantStub.getName())
                .address(restaurantStub.getAddress())
                .city(restaurantStub.getCity())
                .state(restaurantStub.getState())
                .imageURL(restaurantStub.getImageURL())
                .cuisines(restaurantStub.getCuisines())
                .postalCode(restaurantStub.getPostalCode())
                .latitude(restaurantStub.getLatitude())
                .longitude(restaurantStub.getLongitude())
                .starNumber(restaurantStub.getStarNumber())
                .build();
    }
}
