package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.shoedtos.ShoeDto;
import com.example.thirdtask.entities.BaskShoe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoeMapper {
    ShoeDto toShoeDto(BaskShoe baskShoe);

}
