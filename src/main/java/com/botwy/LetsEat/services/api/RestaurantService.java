package com.botwy.LetsEat.services.api;

import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.model.entity.Review;

import java.util.Collection;

public interface RestaurantService {
    Collection<Restaurant> getAll();
    Restaurant create(Restaurant restaurant);
    Restaurant get(Long id);
    Restaurant addReviewToRestaurantWithId(Review review, Long id);
    Restaurant update(Restaurant restaurant);
    RestaurantDTO getDetail(Long id);
}
