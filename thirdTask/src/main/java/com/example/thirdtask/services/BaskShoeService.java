package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.shoedtos.ShoeDto;
import com.example.thirdtask.entities.BaskShoe;
import com.example.thirdtask.entities.BaskShop;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.ShoeMapper;
import com.example.thirdtask.repositories.BaskShoeRepository;
import com.example.thirdtask.repositories.BaskShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class BaskShoeService {
    private final BaskShoeRepository baskShoeRepository;
    private final ShoeMapper shoeMapper;
    private final BaskShopRepository baskShopRepository;

    @Autowired
    public BaskShoeService(BaskShoeRepository baskShoeRepository, ShoeMapper shoeMapper,
                           BaskShopRepository baskShopRepository) {
        this.baskShoeRepository = baskShoeRepository;
        this.shoeMapper = shoeMapper;
        this.baskShopRepository = baskShopRepository;
    }

    public List<ShoeDto> getAllBaskShoes() {
        return baskShoeRepository.findAll().stream().map(shoeMapper::toShoeDto).toList();
    }

    public ShoeDto getBaskShoeById(Integer id) {
        var shoe = baskShoeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return shoeMapper.toShoeDto(shoe);
    }

    public void addBaskShoe(BaskShoe baskShoe) {
        baskShoeRepository.save(baskShoe);
    }

    public void updateBaskShoe(Integer id, BaskShoe baskShoe) {
        var existingUser = baskShoeRepository.findById(baskShoe.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        baskShoe.setId(id);

        baskShoeRepository.save(baskShoe);
    }

    public void removeBaskShoeById(Integer id) {
        var existingUser = baskShoeRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        baskShoeRepository.deleteById(id);
    }

    public List<ShoeDto> getShoeByShopId(Integer shopId) {
        var shop = baskShopRepository.findById(shopId).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));

        var shopSet = new HashSet<BaskShop>();
        shopSet.add(shop);
        List<BaskShoe> shoes;

        shoes = baskShoeRepository.findAllByShopContains(shopSet);

        return shoes.stream().map(shoeMapper::toShoeDto).toList();
    }

}
