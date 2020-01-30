package com.botwy.services.impl;

import com.botwy.LetsEat.Application;
import com.botwy.LetsEat.dao.api.RestaurantDAO;
import com.botwy.LetsEat.dao.impl.RestaurantDAOImpl;
import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.services.api.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class RestaurantDaoImplTest {

    private RestaurantDAOImpl restaurantDAO;

    @Autowired
    public RestaurantDaoImplTest(RestaurantDAOImpl restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @Test
    public void getAllRestaurant() {
        List<Restaurant> restaurants = restaurantDAO.getAll();
        assertEquals(restaurants.size(), 67);
    }
}
