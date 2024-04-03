package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.supplydtos.GetSupplyDto;
import com.example.thirdtask.dtos.userappdtos.AddUserAppDto;
import com.example.thirdtask.dtos.userappdtos.GetUserAppDto;
import com.example.thirdtask.entities.Supply;
import com.example.thirdtask.entities.UserApp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyMapper {
    GetSupplyDto supplyToGetSupplyDto(Supply supply);

    UserApp addUserDtoToUser(AddUserAppDto addChatDto);
}