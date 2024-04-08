package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.cartdtos.CartDto;
import com.example.thirdtask.entities.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toCartDto(ShoppingCart shoppingCart);

}
