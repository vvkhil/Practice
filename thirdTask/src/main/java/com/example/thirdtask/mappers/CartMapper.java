package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.cartdtos.GetCartDto;
import com.example.thirdtask.entities.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    GetCartDto cartToGetCartDto(ShoppingCart shoppingCart);

}
