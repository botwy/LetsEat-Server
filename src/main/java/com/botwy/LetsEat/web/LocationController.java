package com.botwy.LetsEat.web;

import com.botwy.LetsEat.services.api.LocationService;
import com.botwy.LetsEat.services.api.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/locations")
    public String[] restaurants() {
        return locationService.getAll();
    }
}
