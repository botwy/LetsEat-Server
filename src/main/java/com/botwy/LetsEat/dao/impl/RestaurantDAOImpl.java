package com.botwy.LetsEat.dao.impl;

import com.botwy.LetsEat.dao.api.RestaurantDAO;
import com.botwy.LetsEat.entity.Restaurant;
import com.botwy.LetsEat.model.dto.BaseResponse;
import com.botwy.LetsEat.model.dto.RestaurantStub;
import com.botwy.LetsEat.model.dto.RestaurantStubInput;
import com.botwy.LetsEat.services.mappers.RestaurantMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantDAOImpl implements RestaurantDAO {

    @Override
    public List<Restaurant> getAll() {
        URL pathAspen = getClass().getResource("/Aspen.json");
        URL pathBoston = getClass().getResource("/Boston.json");
        URL pathCharleston = getClass().getResource("/Charleston.json");
        ObjectMapper mapper = new ObjectMapper();
        List<RestaurantStub> restaurantStubs = new ArrayList<>();
        try {
            BaseResponse<RestaurantStubInput> aspenRestaurantStubs = mapper.readValue(pathAspen,  new TypeReference<BaseResponse<RestaurantStubInput>>() {});
            restaurantStubs.addAll(aspenRestaurantStubs.getBody().getRestaurants());
            BaseResponse<RestaurantStubInput> bostonRestaurantStubs = mapper.readValue(pathBoston,  new TypeReference<BaseResponse<RestaurantStubInput>>() {});
            restaurantStubs.addAll(bostonRestaurantStubs.getBody().getRestaurants());
            BaseResponse<RestaurantStubInput> charlestonRestaurantStubs = mapper.readValue(pathCharleston,  new TypeReference<BaseResponse<RestaurantStubInput>>() {});
            restaurantStubs.addAll(charlestonRestaurantStubs.getBody().getRestaurants());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Restaurant> restaurants = new ArrayList<>();
        RestaurantMapper restaurantMapper = new RestaurantMapper();

        for (RestaurantStub restaurantStub : restaurantStubs) {
            Restaurant restaurant = restaurantMapper.restaurantFromStub(restaurantStub);
            restaurants.add(restaurant);
        }

        return restaurants;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        URL pathDetail = getClass().getResource("/" + id + "_Detail.json");
        if (pathDetail == null) {
            throw new RuntimeException("Missing detail for id=" + id);
        }
        ObjectMapper mapper = new ObjectMapper();
        RestaurantStub restaurantStub = null;
        try {
            restaurantStub = mapper.readValue(pathDetail, RestaurantStub.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestaurantMapper restaurantMapper = new RestaurantMapper();

        if (restaurantStub == null) {
            throw new RuntimeException("Missing detail for id=" + id);
        }

        return restaurantMapper.restaurantFromStub(restaurantStub);
    }
}
