package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.roledtos.GetRoleDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.RoleMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<GetRoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map(roleMapper::roleToGetRoleDto).toList();
    }

    public GetRoleDto getRoleById(Integer id) {
        var role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return roleMapper.roleToGetRoleDto(role);
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void updateRole(Role role) {
        var existingUser = roleRepository.findById(role.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        roleRepository.save(role);
    }

    public void removeRoleById(Integer id) {
        var existingUser = roleRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        roleRepository.deleteById(id);
    }

}
