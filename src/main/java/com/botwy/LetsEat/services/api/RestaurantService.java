package com.botwy.LetsEat.services.api;

import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.model.entity.Restaurant;

import java.util.Collection;

public interface RestaurantService {
    Collection<Restaurant> getAll();
    Restaurant create(Restaurant restaurant);
    RestaurantDTO getDetail(int id);

}
