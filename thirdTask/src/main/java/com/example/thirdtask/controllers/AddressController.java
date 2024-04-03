package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.entities.Address;
import com.example.thirdtask.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> addAddress(Address address) {
        addressService.addAddress(address);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/addresses")
    public ResponseEntity<Object> updateAddress(Address address) {
        addressService.updateAddress(address);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Object> removeAddressById(@PathVariable Integer id) {
        addressService.removeAddressById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
