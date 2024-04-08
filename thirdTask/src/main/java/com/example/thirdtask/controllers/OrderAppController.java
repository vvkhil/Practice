package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.orderdtos.OrderDto;
import com.example.thirdtask.entities.OrderApp;
import com.example.thirdtask.services.OrderAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderAppController {
    final OrderAppService orderAppService;

    @Autowired
    public OrderAppController(OrderAppService orderAppService) {
        this.orderAppService = orderAppService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getOrderApp() {
        var orders = orderAppService.getAllOrders();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDto> getOrderAppById(@PathVariable Integer id) {
        var orders = orderAppService.getOrderAppById(id);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Object> addOrderApp(OrderApp orderApp) {
        orderAppService.addOrderApp(orderApp);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/orders")
    public ResponseEntity<Object> updateOrderApp(OrderApp orderApp) {
        orderAppService.updateOrderApp(orderApp);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Object> removeOrderAppById(@PathVariable Integer id) {
        orderAppService.removeOrderAppById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
