package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.shopdtos.GetShopDto;
import com.example.thirdtask.entities.BaskShop;
import com.example.thirdtask.services.BaskShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaskShopController {
    @Autowired
    BaskShopService baskShopService;

    @GetMapping("/shops")
    public ResponseEntity<List<GetShopDto>> getBaskShop() {
        var shops = baskShopService.getAllBaskShops();

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<GetShopDto> getBaskShopById(@PathVariable Integer id) {
        var shops = baskShopService.getBaskShopById(id);

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping("/shops")
    public ResponseEntity<Object> addBaskShop(BaskShop baskShop) {
        baskShopService.addBaskShop(baskShop);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/shops")
    public ResponseEntity<Object> updateBaskShop(BaskShop baskShop) {
        baskShopService.updateBaskShoe(baskShop);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<Object> removeBaskShopById(@PathVariable Integer id) {
        baskShopService.removeBaskShopById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
