package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.shopdtos.GetShopDto;
import com.example.thirdtask.dtos.supplydtos.GetSupplyDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.ForbiddenException;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.ShopMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public void addBaskShop(BaskShop baskShop, Integer authenticatedUserId) {
        if (!Objects.equals(authenticatedUserId, baskShop.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        baskShopRepository.save(baskShop);
    }

    public void updateBaskShoe(BaskShop baskShop, Integer authenticatedUserId) {
        var existingShop = baskShopRepository.findById(baskShop.getId());

        if (existingShop.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, baskShop.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        baskShopRepository.save(baskShop);
    }

    public void removeBaskShopById(Integer id, Integer authenticatedUserId) {
        var existingShop = baskShopRepository.findById(id);

        if (existingShop.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, existingShop.get().getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        baskShopRepository.deleteById(id);
    }

    public List<GetShopDto> getBaskShopByUserId(Integer userId) {
        return baskShopRepository.findByUserId(userId).stream().map(shopMapper::shopToGetShopDto).toList();
    }

}
