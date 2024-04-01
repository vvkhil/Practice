package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.customerdtos.GetCustomerDto;
import com.example.thirdtask.entities.Customer;
import com.example.thirdtask.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        var customers = customerService.getAllCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

//    @GetMapping("/customers")
//    public ResponseEntity<List<GetCustomerDto>> getCustomers() {
//        var customers = customerService.getAllCustomers();
//
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        var customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> addCustomer(Customer customer) {
        customerService.addCustomer(customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<Object> updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Object> removeAddressById(@PathVariable Integer id) {
        customerService.removeCustomerById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
