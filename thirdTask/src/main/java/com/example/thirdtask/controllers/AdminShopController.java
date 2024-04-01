package com.example.thirdtask.controllers;


import com.example.thirdtask.entities.Address;
import com.example.thirdtask.entities.AdminShop;
import com.example.thirdtask.services.AddressService;
import com.example.thirdtask.services.AdminShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminShopController {
    @Autowired
    AdminShopService adminShopService;

    @GetMapping("/admins")
    public ResponseEntity<List<AdminShop>> getAdminShop() {
        var admins = adminShopService.getAllAdmins();

        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<AdminShop> getAdminById(@PathVariable Integer id) {
        var admins = adminShopService.getAdminById(id);

        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @PostMapping("/admins")
    public ResponseEntity<Object> addAdmin(AdminShop adminShop) {
        adminShopService.addAdmin(adminShop);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admins")
    public ResponseEntity<Object> updateAdmin(AdminShop adminShop) {
        adminShopService.updateAdmin(adminShop);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Object> removeAdminById(@PathVariable Integer id) {
        adminShopService.removeAdminById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
