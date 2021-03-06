package com.botwy.services.impl;

import com.botwy.LetsEat.Application;
import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.services.impl.RestaurantServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class RestaurantServiceImplTest {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantServiceImplTest(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Test
    public void getAllRestaurant() {
        List<Restaurant> restaurants = restaurantService.getAll();
        assertEquals(restaurants.size(), 67);
    }
}
