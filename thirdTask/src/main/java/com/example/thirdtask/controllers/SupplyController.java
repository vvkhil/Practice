package com.example.thirdtask.controllers;


import com.example.thirdtask.entities.OrderApp;
import com.example.thirdtask.entities.Provider;
import com.example.thirdtask.entities.Supply;
import com.example.thirdtask.services.OrderAppService;
import com.example.thirdtask.services.ProviderService;
import com.example.thirdtask.services.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplyController {
    final SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping("/supplies")
    public ResponseEntity<List<Supply>> getSupply() {
        var supplies = supplyService.getAllSupplies();

        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    @GetMapping("/supplies/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable Integer id) {
        var supplies = supplyService.getSupplyById(id);

        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    @PostMapping("/supplies")
    public ResponseEntity<Object> addSupply(Supply supply) {
        supplyService.addSupply(supply);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/supplies")
    public ResponseEntity<Object> updateSupply(Supply supply) {
        supplyService.updateSupply(supply);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/supplies/{id}")
    public ResponseEntity<Object> removeSupplyById(@PathVariable Integer id) {
        supplyService.removeSupplyById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
