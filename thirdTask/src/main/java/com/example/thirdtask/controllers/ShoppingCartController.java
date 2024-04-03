package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.cartdtos.GetCartDto;
import com.example.thirdtask.entities.ShoppingCart;
import com.example.thirdtask.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/carts")
    public ResponseEntity<List<GetCartDto>> getShoppingCart() {
        var carts = shoppingCartService.getAllShoppingCarts();

        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<GetCartDto> getShoppingCartById(@PathVariable Integer id) {
        var carts = shoppingCartService.getShoppingCartById(id);

        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PostMapping("/carts")
    public ResponseEntity<Object> addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartService.addShoppingCart(shoppingCart);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/carts")
    public ResponseEntity<Object> updateShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartService.updateShoppingCart(shoppingCart);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Object> removeShoppingCartById(@PathVariable Integer id) {
        shoppingCartService.removeShoppingCartById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
