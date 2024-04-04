package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.userappdtos.GetUserAppDto;
import com.example.thirdtask.entities.UserApp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAppMapper {
    GetUserAppDto userToGetUserDto(UserApp userApp);

}