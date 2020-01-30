package com.botwy.LetsEat.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantStubInput {
    List<RestaurantStub> restaurants;
}
