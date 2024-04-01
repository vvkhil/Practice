package com.example.thirdtask.dtos.userappdtos;

import lombok.Data;

@Data
public class GetUserAppDto {
    private Integer id;
    private String login;
    private String email;
}