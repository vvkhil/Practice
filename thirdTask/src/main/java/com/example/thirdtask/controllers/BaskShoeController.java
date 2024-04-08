package com.example.thirdtask.controllers;


import com.example.thirdtask.dtos.shoedtos.ShoeDto;
import com.example.thirdtask.entities.BaskShoe;
import com.example.thirdtask.services.BaskShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaskShoeController {
    private final BaskShoeService baskShoeService;

    @Autowired
    public BaskShoeController(BaskShoeService baskShoeService) {
        this.baskShoeService = baskShoeService;
    }

    @GetMapping("/shoes")
    public ResponseEntity<List<ShoeDto>> getBaskShoe() {
        var shoes = baskShoeService.getAllBaskShoes();

        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }

    @GetMapping("/shoes/{id}")
    public ResponseEntity<ShoeDto> getBaskShoeById(@PathVariable Integer id) {
        var shoes = baskShoeService.getBaskShoeById(id);

        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }

    @PostMapping("/shoes")
    public ResponseEntity<Object> addBaskShoe(BaskShoe baskShoe) {
        baskShoeService.addBaskShoe(baskShoe);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/shoes")
    public ResponseEntity<Object> updateBaskShoe(BaskShoe baskShoe) {
        baskShoeService.updateBaskShoe(baskShoe);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/shoes/{id}")
    public ResponseEntity<Object> removeBaskShoeById(@PathVariable Integer id) {
        baskShoeService.removeBaskShoeById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shops/{id}/shoes")
    public ResponseEntity<List<ShoeDto>> getShoesByShopId(@PathVariable Integer id, @RequestParam boolean isInShop) {
        var shoes = baskShoeService.getShoeByShopId(id, isInShop);

        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }

}
