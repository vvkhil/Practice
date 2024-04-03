package com.example.thirdtask.dtos.addressdtos;

import lombok.Data;

@Data
public class GetAddressDto {
    private Integer id;
    private String city;
    private String street;
    private String house;
    private String flat;
}
