package com.example.thirdtask.dtos.userappdtos;

import lombok.Data;

@Data
public class AddUserAppDto {
    private Integer id;
    private String login;
    private String email;
    private String password;
}
