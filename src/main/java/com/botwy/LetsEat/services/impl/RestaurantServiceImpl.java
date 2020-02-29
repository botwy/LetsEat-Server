package com.botwy.LetsEat.services.impl;

import com.botwy.LetsEat.dao.api.RestaurantDAO;
import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.model.entity.Review;
import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.model.dto.RestaurantStub;
import com.botwy.LetsEat.services.mappers.RestaurantMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDAO restaurantDAO;

    @Override
    public Collection<Restaurant> getAll() {
        Collection<Restaurant> restaurants = restaurantDAO.getAll();
        restaurants.forEach(restaurant -> System.out.println(restaurant.getReviews()));
        return restaurants;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Restaurant newRestaurant = restaurantDAO.create(restaurant);
        System.out.println("restaurant.getReviews()");
        System.out.println(newRestaurant.getReviews());
        return newRestaurant;
    }

    @Override
    public Restaurant get(Long id) {
        Restaurant restaurant = restaurantDAO.restaurantBy(id);
        System.out.println("restaurant.getReviews()");
        System.out.println(restaurant.getReviews());
        return restaurant;
    }

    @Override
    public Restaurant addReviewToRestaurantWithId(Review review, Long id) {
        Restaurant restaurant = restaurantDAO.restaurantBy(id);
        Collection<Review> reviews = restaurant.getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
            restaurant.setReviews(reviews);
        }
        reviews.add(review);

        return restaurantDAO.update(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantDAO.update(restaurant);
    }

    @Override
    public RestaurantDTO getDetail(Long restaurantId) {
        URL pathDetail = getClass().getResource("/" + restaurantId + "_Detail.json");
        if (pathDetail == null) {
            throw new RuntimeException("Missing detail for id=" + restaurantId);
        }
        ObjectMapper mapper = new ObjectMapper();
        RestaurantStub restaurantStub = null;
        try {
            restaurantStub = mapper.readValue(pathDetail, RestaurantStub.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestaurantMapper restaurantMapper = new RestaurantMapper();

        return restaurantMapper.fromStub(restaurantStub);
    }
}
