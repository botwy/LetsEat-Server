package com.botwy.LetsEat.services.api;

import com.botwy.LetsEat.services.dto.RestaurantDTO;

public interface RestaurantService {
    RestaurantDTO[] getAll();
    RestaurantDTO getDetail(int id);

}
