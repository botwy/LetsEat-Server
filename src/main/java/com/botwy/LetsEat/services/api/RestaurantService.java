package com.botwy.LetsEat.services.api;

import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.model.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant getDetail(int id);
}
