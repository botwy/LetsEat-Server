package com.botwy.LetsEat.dao.impl;

import com.botwy.LetsEat.dao.api.RestaurantDAO;
import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.model.entity.Review;
import com.botwy.LetsEat.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RestaurantDAOImpl implements RestaurantDAO {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Collection<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant restaurantBy(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (!restaurant.isPresent()) {
            throw new RuntimeException("Missing restaurant with id=" + id);
        }
        return restaurant.get();
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        if (restaurant.getId() == null) {
            throw new RuntimeException("Missing id in restaurant with name " + restaurant.getName());
        }
        return restaurantRepository.save(restaurant);
    }
}
