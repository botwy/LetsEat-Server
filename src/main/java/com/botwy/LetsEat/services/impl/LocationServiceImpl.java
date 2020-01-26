package com.botwy.LetsEat.services.impl;

import com.botwy.LetsEat.services.api.LocationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class LocationServiceImpl implements LocationService {

    @Override
    public String[] getAll() {
        URL path = getClass().getResource("/Location.json");
        ObjectMapper mapper = new ObjectMapper();
        String[] locations = null;
        try {
            locations = mapper.readValue(path, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return locations;
    }
}
