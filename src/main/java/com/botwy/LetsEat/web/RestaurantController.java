package com.botwy.LetsEat.web;

import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurants")
    public Collection<Restaurant> restaurants() {
        return restaurantService.getAll();
    }

    @RequestMapping(value = "/restaurants/create", method = RequestMethod.POST)
    public Restaurant restaurants(@RequestBody Restaurant restaurant) {
        return restaurantService.create(restaurant);
    }

    @RequestMapping("/restaurants/{id}")
    public RestaurantDTO restaurantDetail(@PathVariable("id") int restaurantId) {
        return restaurantService.getDetail(restaurantId);
    }
}
