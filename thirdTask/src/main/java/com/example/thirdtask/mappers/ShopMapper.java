package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.shopdtos.ShopDto;
import com.example.thirdtask.entities.BaskShop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    ShopDto toShopDto(BaskShop baskShop);

}