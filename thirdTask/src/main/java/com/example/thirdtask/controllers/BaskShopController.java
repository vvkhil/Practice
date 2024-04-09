package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.shopdtos.ShopDto;
import com.example.thirdtask.entities.BaskShop;
import com.example.thirdtask.services.BaskShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class BaskShopController {
    final BaskShopService baskShopService;

    @Autowired
    public BaskShopController(BaskShopService baskShopService) {
        this.baskShopService = baskShopService;
    }

    @GetMapping("/shops")
    public ResponseEntity<List<ShopDto>> getBaskShop() {
        var shops = baskShopService.getAllBaskShops();

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<ShopDto> getBaskShopById(@PathVariable Integer id) {
        var shops = baskShopService.getBaskShopById(id);

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping("/shops/add/")
    public ResponseEntity<Object> addBaskShop(@RequestBody BaskShop baskShop, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        baskShopService.addBaskShop(baskShop, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/shops/update/{id}")
    public ResponseEntity<Object> updateBaskShop(@PathVariable Integer id, @RequestBody BaskShop baskShop, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        baskShopService.updateBaskShoe(id, baskShop, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<Object> removeBaskShopById(@PathVariable Integer id, Principal principal) {
        var authenticatedUserId = Integer.parseInt(principal.getName());
        baskShopService.removeBaskShopById(id, authenticatedUserId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/shops/add/{shopId}/shoes/{shoeId}")
    public ResponseEntity<Object> addShoeToShop(@PathVariable Integer shopId, @PathVariable Integer shoeId) {
        baskShopService.addShoeToShop(shopId, shoeId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/shops/delete/{shopId}/shoes/{shoeId}")
    public ResponseEntity<Object> removeShoeFromShop(@PathVariable Integer shopId, @PathVariable Integer shoeId) {
        baskShopService.removeShoeFromShop(shopId, shoeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shoes/{id}/shops")
    public ResponseEntity<List<ShopDto>> getShopsByShoeId(@PathVariable Integer id) {
        var shops = baskShopService.getShopsByShoeId(id);

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/shops")
    public ResponseEntity<List<ShopDto>> getBaskShopByUserId(@PathVariable Integer id) {
        var shops = baskShopService.getBaskShopByUserId(id);

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

}
