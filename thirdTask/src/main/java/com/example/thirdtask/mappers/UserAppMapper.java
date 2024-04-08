package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.userappdtos.UserAppDto;
import com.example.thirdtask.entities.UserApp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAppMapper {
    UserAppDto toUserDto(UserApp userApp);

}