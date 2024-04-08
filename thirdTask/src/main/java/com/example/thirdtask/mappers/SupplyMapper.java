package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.supplydtos.SupplyDto;
import com.example.thirdtask.entities.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyMapper {
    SupplyDto toSupplyDto(Supply supply);

}