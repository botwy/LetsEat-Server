package com.botwy.LetsEat.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BaseResponse<T> {
    T body;
}
