package com.botwy.LetsEat.web;

import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.services.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurants")
    public RestaurantDTO[] restaurants() {
        return restaurantService.getAll();
    }

    @RequestMapping("/restaurants/{id}")
    public RestaurantDTO restaurantDetail(@PathVariable("id") int restaurantId) {
        return restaurantService.getDetail(restaurantId);
    }
}
