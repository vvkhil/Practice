package com.example.thirdtask.controllers;


import com.example.thirdtask.entities.OrderApp;
import com.example.thirdtask.entities.Provider;
import com.example.thirdtask.services.OrderAppService;
import com.example.thirdtask.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {
    final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/providers")
    public ResponseEntity<List<Provider>> getProvider() {
        var providers = providerService.getAllProviders();

        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/providers/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Integer id) {
        var providers = providerService.getProviderById(id);

        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @PostMapping("/providers")
    public ResponseEntity<Object> addProvider(Provider provider) {
        providerService.addProvider(provider);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/providers")
    public ResponseEntity<Object> updateProvider(Provider provider) {
        providerService.updateProvider(provider);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/providers/{id}")
    public ResponseEntity<Object> removeProviderById(@PathVariable Integer id) {
        providerService.removeProviderById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
