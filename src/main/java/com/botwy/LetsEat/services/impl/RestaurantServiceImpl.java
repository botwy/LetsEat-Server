package com.botwy.LetsEat.services.impl;

import com.botwy.LetsEat.services.api.RestaurantService;
import com.botwy.LetsEat.model.dto.RestaurantDTO;
import com.botwy.LetsEat.model.dto.RestaurantStub;
import com.botwy.LetsEat.services.mappers.RestaurantMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Override
    public RestaurantDTO[] getAll() {
        URL pathAspen = getClass().getResource("/Aspen.json");
        URL pathBoston = getClass().getResource("/Boston.json");
        URL pathCharleston = getClass().getResource("/Charleston.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<RestaurantStub> restaurantStubs = new ArrayList<>();
        try {
            Collections.addAll(restaurantStubs, mapper.readValue(pathAspen, RestaurantStub[].class));
            Collections.addAll(restaurantStubs, mapper.readValue(pathBoston, RestaurantStub[].class));
            Collections.addAll(restaurantStubs, mapper.readValue(pathCharleston, RestaurantStub[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestaurantDTO[] restaurantDTOs = new RestaurantDTO[restaurantStubs.size()];
        RestaurantMapper restaurantMapper = new RestaurantMapper();
        for (int i = 0; i < restaurantDTOs.length; i++) {
            restaurantDTOs[i] = restaurantMapper.fromStub(restaurantStubs.get(i));
        }

        return restaurantDTOs;
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
