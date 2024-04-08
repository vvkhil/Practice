package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.addressdtos.AddressDto;
import com.example.thirdtask.entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toAddressDto(Address address);

}