package com.botwy.LetsEat.services.mappers;

import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.model.dto.RestaurantStub;
import com.botwy.LetsEat.model.dto.RestaurantStubInput;

public class RestaurantMapper {
    public Restaurant restaurantFromStub(RestaurantStub restaurantStub) {
        return Restaurant.builder()
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

    public RestaurantDTO dtoFromRestaurant(Restaurant restaurant) {
        return RestaurantDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .city(restaurant.getCity())
                .state(restaurant.getState())
                .imageURL(restaurant.getImageURL())
                .cuisines(restaurant.getCuisines())
                .postalCode(restaurant.getPostalCode())
                .latitude(restaurant.getLatitude())
                .longitude(restaurant.getLongitude())
                .starNumber(restaurant.getStarNumber())
                .build();
    }
}
