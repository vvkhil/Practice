package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.orderdtos.OrderDto;
import com.example.thirdtask.entities.OrderApp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toOrderDto(OrderApp orderApp);

}
