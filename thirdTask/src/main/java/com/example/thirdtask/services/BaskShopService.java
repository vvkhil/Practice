package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaskShopService {
    private final BaskShopRepository baskShopRepository;

    @Autowired
    public BaskShopService(BaskShopRepository baskShopRepository) {
        this.baskShopRepository = baskShopRepository;
    }

    public List<BaskShop> getAllBaskShops() {
        return baskShopRepository.findAll();
    }

    public BaskShop getBaskShopById(Integer id) {
        return baskShopRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
    }

    public void addBaskShop(BaskShop baskShop) {
        baskShopRepository.save(baskShop);
    }

    public void updateBaskShoe(BaskShop baskShop) {
        var existingUser = baskShopRepository.findById(baskShop.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        baskShopRepository.save(baskShop);
    }

    public void removeBaskShopById(Integer id) {
        var existingUser = baskShopRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        baskShopRepository.deleteById(id);
    }

}
