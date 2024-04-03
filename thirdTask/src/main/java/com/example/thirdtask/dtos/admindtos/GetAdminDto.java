package com.example.thirdtask.dtos.admindtos;

import lombok.Data;

@Data
public class GetAdminDto {
    private Integer id;
    private String city;
    private String street;
    private String house;
    private String flat;
}

