package com.botwy.services.impl;

import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.services.impl.RestaurantServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantServiceImplTest {

    private RestaurantService restaurantService;

    @BeforeEach
    void init() {
      restaurantService = new RestaurantServiceImpl();
    }

    @Test
    public void getAllRestaurant() {
        Collection<Restaurant> restaurants = restaurantService.getAll();
        assertEquals(restaurants.size(), 0);
    }
}
