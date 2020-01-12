package com.botwy.LetsEat.services.api;

import com.botwy.LetsEat.model.dto.RestaurantDTO;

public interface RestaurantService {
    RestaurantDTO[] getAll();
    RestaurantDTO getDetail(int id);

}
