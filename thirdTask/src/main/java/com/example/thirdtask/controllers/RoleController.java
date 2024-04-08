package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.roledtos.RoleDto;
import com.example.thirdtask.entities.Role;
import com.example.thirdtask.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDto>> getRole() {
        var roles = roleService.getAllRoles();

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable Integer id) {
        var roles = roleService.getRoleById(id);

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<Object> addRole(Role role) {
        roleService.addRole(role);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/roles")
    public ResponseEntity<Object> updateRole(Role role) {
        roleService.updateRole(role);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Object> removeSupplyById(@PathVariable Integer id) {
        roleService.removeRoleById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
