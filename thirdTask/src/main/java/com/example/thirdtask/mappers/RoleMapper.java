package com.example.thirdtask.mappers;

import com.example.thirdtask.dtos.roledtos.RoleDto;
import com.example.thirdtask.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toRoleDto(Role role);

}
