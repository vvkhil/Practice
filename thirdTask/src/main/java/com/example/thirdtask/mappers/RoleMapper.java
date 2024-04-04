package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.roledtos.GetRoleDto;
import com.example.thirdtask.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    GetRoleDto roleToGetRoleDto(Role role);

}
