package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.shopdtos.GetShopDto;
import com.example.thirdtask.dtos.supplydtos.GetSupplyDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.AlreadyExistsException;
import com.example.thirdtask.exceptions.ForbiddenException;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.ShopMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class BaskShopService {
    private final BaskShopRepository baskShopRepository;
    private final ShopMapper shopMapper;
    private final BaskShoeRepository baskShoeRepository;

    @Autowired
    public BaskShopService(BaskShopRepository baskShopRepository, ShopMapper shopMapper,
                           BaskShoeRepository baskShoeRepository) {
        this.baskShopRepository = baskShopRepository;
        this.shopMapper = shopMapper;
        this.baskShoeRepository = baskShoeRepository;
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

    public void addShoeToShop(Integer shopId, Integer shoeId) {
        var shop = baskShopRepository.findById(shopId).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));

        if (shop.getShoe().stream().anyMatch(shoe -> shoe.getId().toString().equals(shoeId.toString()))) {
            throw new AlreadyExistsException(Constants.CONFLICT);
        }

        var shoe = baskShoeRepository.findById(shoeId).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        shop.getShoe().add(shoe);
        baskShopRepository.save(shop);
    }

    public void removeShoeFromShop(Integer shopId, Integer shoeId) {
        var shop = baskShopRepository.findById(shopId).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));

        if (shop.getShoe().stream().noneMatch(shoe -> shoe.getId().toString().equals(shoeId.toString()))) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        shop.getShoe().removeIf(shoe -> shoe.getId().toString().equals(shoeId.toString()));
        baskShopRepository.save(shop);
    }

    public List<GetShopDto> getShopsByShoeId(Integer shoeId) {
        var shoe = baskShoeRepository.findById(shoeId).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        var shoeSet = new HashSet<BaskShoe>();
        shoeSet.add(shoe);
        var shops = baskShopRepository.findAllByShoeContains(shoeSet);

        return shops.stream().map(shopMapper::shopToGetShopDto).toList();
    }

    public List<GetShopDto> getBaskShopByUserId(Integer userId) {
        return baskShopRepository.findByUserId(userId).stream().map(shopMapper::shopToGetShopDto).toList();
    }

}
