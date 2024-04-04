package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.orderdtos.GetOrderDto;
import com.example.thirdtask.entities.OrderApp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    GetOrderDto orderToGetOrderDto(OrderApp orderApp);

}
