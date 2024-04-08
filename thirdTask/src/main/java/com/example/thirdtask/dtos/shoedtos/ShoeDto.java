package com.example.thirdtask.dtos.shoedtos;

import lombok.Data;

@Data
public class ShoeDto {
    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private String manufacturer;
    private String brand;
    private Integer size;
}
