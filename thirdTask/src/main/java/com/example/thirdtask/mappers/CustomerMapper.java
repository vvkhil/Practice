package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.customerdtos.GetCustomerDto;
import com.example.thirdtask.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    GetCustomerDto customerToGetCustomerDto(Customer customer);

}