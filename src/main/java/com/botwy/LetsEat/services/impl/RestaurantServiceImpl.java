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
import java.util.Collection;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDAO restaurantDAO;

    @Override
    public Collection<Restaurant> getAll() {
        return restaurantDAO.getAll();
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantDAO.create(restaurant);
    }

    @Override
    public Restaurant get(Long id) {
        return restaurantDAO.restaurantBy(id);
    }

    @Override
    public Restaurant addReviewToRestaurantWithId(Review review, Long id) {
        return restaurantDAO.addReviewToRestaurantWithId(review, id);
    }

    @Override
    public RestaurantDTO getDetail(int restaurantId) {
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
