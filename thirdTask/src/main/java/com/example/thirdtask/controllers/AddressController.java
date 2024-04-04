package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.entities.Address;
import com.example.thirdtask.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<GetAddressDto>> getAddresses() {
        var addresses = addressService.getAllAddresses();

        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<GetAddressDto> getAddressById(@PathVariable Integer id) {
        var address = addressService.getAddressById(id);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/addresses")
    public ResponseEntity<Object> addAddress(@RequestBody Address address, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        addressService.addAddress(address, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/addresses")
    public ResponseEntity<Object> updateAddress(@RequestBody Address address, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        addressService.updateAddress(address, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Object> removeAddressById(@PathVariable Integer id, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        addressService.removeAddressById(id, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}/addresses")
    public ResponseEntity<List<GetAddressDto>> getAddressByUserId(@PathVariable Integer id) {
        var addresses = addressService.getAddressByUserId(id);

        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

}
