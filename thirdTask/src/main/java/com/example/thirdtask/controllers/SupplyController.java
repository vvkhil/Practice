package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.addressdtos.GetAddressDto;
import com.example.thirdtask.dtos.supplydtos.GetSupplyDto;
import com.example.thirdtask.entities.Supply;
import com.example.thirdtask.services.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class SupplyController {
    final SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping("/supplies")
    public ResponseEntity<List<GetSupplyDto>> getSupply() {
        var supplies = supplyService.getAllSupplies();

        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    @GetMapping("/supplies/{id}")
    public ResponseEntity<GetSupplyDto> getSupplyById(@PathVariable Integer id) {
        var supplies = supplyService.getSupplyById(id);

        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    @PostMapping("/supplies")
    public ResponseEntity<Object> addSupply(@RequestBody Supply supply, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        supplyService.addSupply(supply, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/supplies")
    public ResponseEntity<Object> updateSupply(@RequestBody Supply supply, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        supplyService.updateSupply(supply, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/supplies/{id}")
    public ResponseEntity<Object> removeSupplyById(@PathVariable Integer id, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        supplyService.removeSupplyById(id, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}/supplies")
    public ResponseEntity<List<GetSupplyDto>> getSupplyByUserId(@PathVariable Integer id) {
        var supplies = supplyService.getSupplyByUserId(id);

        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

}
