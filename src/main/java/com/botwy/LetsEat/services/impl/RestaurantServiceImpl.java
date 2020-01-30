package com.botwy.LetsEat.services.impl;

import com.botwy.LetsEat.dao.api.RestaurantDAO;
import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.services.api.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantDAO restaurantDAO;

    @Autowired
    public RestaurantServiceImpl(RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantDAO.getAll();
    }

    @Override
    public Restaurant getDetail(int restaurantId) {
        return restaurantDAO.getRestaurantById(restaurantId);
    }
}
