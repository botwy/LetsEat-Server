package com.botwy.LetsEat.dao.api;

import com.botwy.LetsEat.entity.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    List<Restaurant> getAll();
    Restaurant getRestaurantById(int id);
}
