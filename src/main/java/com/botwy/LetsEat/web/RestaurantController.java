package com.botwy.LetsEat.web;

import com.botwy.LetsEat.model.entity.Restaurant;
import com.botwy.LetsEat.model.entity.Review;
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
        Long id = restaurantService.create(restaurant).getId();
        return restaurantService.get(id);
    }

    @RequestMapping(value = "/restaurants/{id}/addReview", method = RequestMethod.POST)
    public Restaurant addReview(@PathVariable("id") Long restaurantId, @RequestBody Review review) {
        return restaurantService.addReviewToRestaurantWithId(review, restaurantId);
    }

    @RequestMapping("/restaurants/{id}")
    public Restaurant restaurantDetail(@PathVariable("id") String restaurantId) {
        return restaurantService.get(Long.parseLong(restaurantId, 10));
    }

    @RequestMapping("/restaurants/update")
    public Restaurant restaurantUpdate(@RequestBody Restaurant restaurant) {
        return restaurantService.update(restaurant);
    }
}
