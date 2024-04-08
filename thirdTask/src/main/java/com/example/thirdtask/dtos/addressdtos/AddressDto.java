package com.example.thirdtask.dtos.addressdtos;

import lombok.Data;

@Data
public class AddressDto {
    private Integer id;
    private String city;
    private String street;
    private String house;
    private String flat;
}
