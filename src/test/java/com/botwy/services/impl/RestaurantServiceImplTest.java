package com.botwy.services.impl;

import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.services.dto.RestaurantDTO;
import com.botwy.LetsEat.services.impl.RestaurantServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantServiceImplTest {

    private RestaurantService restaurantService;

    @BeforeEach
    void init() {
      restaurantService = new RestaurantServiceImpl();
    }

    @Test
    public void getAllRestaurant() {
        RestaurantDTO[] restaurants = restaurantService.getAll();
        assertEquals(restaurants.length, 67);
    }
}
