package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.shoedtos.GetShoeDto;
import com.example.thirdtask.entities.BaskShoe;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.ShoeMapper;
import com.example.thirdtask.repositories.BaskShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaskShoeService {
    private final BaskShoeRepository baskShoeRepository;
    private final ShoeMapper shoeMapper;

    @Autowired
    public BaskShoeService(BaskShoeRepository baskShoeRepository, ShoeMapper shoeMapper) {
        this.baskShoeRepository = baskShoeRepository;
        this.shoeMapper = shoeMapper;
    }

    public List<GetShoeDto> getAllBaskShoes() {
        return baskShoeRepository.findAll().stream().map(shoeMapper::shoeToGetShoeDto).toList();
    }

    public GetShoeDto getBaskShoeById(Integer id) {
        var shoe = baskShoeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return shoeMapper.shoeToGetShoeDto(shoe);
    }

    public void addBaskShoe(BaskShoe baskShoe) {
        baskShoeRepository.save(baskShoe);
    }

    public void updateBaskShoe(BaskShoe baskShoe) {
        var existingUser = baskShoeRepository.findById(baskShoe.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        baskShoeRepository.save(baskShoe);
    }

    public void removeBaskShoeById(Integer id) {
        var existingUser = baskShoeRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        baskShoeRepository.deleteById(id);
    }

}
