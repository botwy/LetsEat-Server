package com.botwy.LetsEat.web;

import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.services.mappers.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurants")
    public List<RestaurantDTO> restaurants() {
        List<Restaurant> restaurants = restaurantService.getAll();

        RestaurantMapper restaurantMapper = new RestaurantMapper();
        List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
        for (Restaurant restaurant: restaurants) {
            RestaurantDTO restaurantDTO = restaurantMapper.dtoFromRestaurant(restaurant);
            restaurantDTOs.add(restaurantDTO);
        }

        return restaurantDTOs;
    }

    @RequestMapping("/restaurants/{id}")
    public RestaurantDTO restaurantDetail(@PathVariable("id") int restaurantId) {
        Restaurant restaurant = restaurantService.getDetail(restaurantId);
        RestaurantMapper restaurantMapper = new RestaurantMapper();

        return restaurantMapper.dtoFromRestaurant(restaurant);
    }
}
