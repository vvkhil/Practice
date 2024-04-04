package com.example.thirdtask.mappers;


import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    GetAddressDto addressToGetAddressDto(Address address);

}