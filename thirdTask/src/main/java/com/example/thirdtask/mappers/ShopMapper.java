package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.shopdtos.GetShopDto;
import com.example.thirdtask.entities.BaskShop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    GetShopDto shopToGetShopDto(BaskShop baskShop);

}