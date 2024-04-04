package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.shoedtos.GetShoeDto;
import com.example.thirdtask.entities.BaskShoe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoeMapper {
    GetShoeDto shoeToGetShoeDto(BaskShoe baskShoe);

}
