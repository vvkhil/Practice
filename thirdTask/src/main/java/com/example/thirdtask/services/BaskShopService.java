package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.shopdtos.GetShopDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.ShopMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaskShopService {
    private final BaskShopRepository baskShopRepository;
    private final ShopMapper shopMapper;

    @Autowired
    public BaskShopService(BaskShopRepository baskShopRepository, ShopMapper shopMapper) {
        this.baskShopRepository = baskShopRepository;
        this.shopMapper = shopMapper;
    }

    public List<GetShopDto> getAllBaskShops() {
        return baskShopRepository.findAll().stream().map(shopMapper::shopToGetShopDto).toList();
    }

    public GetShopDto getBaskShopById(Integer id) {
        var shop = baskShopRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return shopMapper.shopToGetShopDto(shop);
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
