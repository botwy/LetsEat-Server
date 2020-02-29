package com.botwy.LetsEat.dao.api;

import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.model.entity.Review;

import java.util.Collection;

public interface RestaurantDAO {
    Collection<Restaurant> getAll();
    Restaurant create(Restaurant restaurant);
    Restaurant restaurantBy(Long id);
    Restaurant update(Restaurant restaurant);
}
