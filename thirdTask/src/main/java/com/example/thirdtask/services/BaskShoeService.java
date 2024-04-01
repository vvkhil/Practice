package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.entities.Address;
import com.example.thirdtask.entities.AdminShop;
import com.example.thirdtask.entities.BaskShoe;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.repositories.AddressRepository;
import com.example.thirdtask.repositories.AdminShopRepository;
import com.example.thirdtask.repositories.BaskShoeRepository;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaskShoeService {
    private final BaskShoeRepository baskShoeRepository;

    @Autowired
    public BaskShoeService(BaskShoeRepository baskShoeRepository) {
        this.baskShoeRepository = baskShoeRepository;
    }

    public List<BaskShoe> getAllBaskShoes() {
        return baskShoeRepository.findAll();
    }

    public BaskShoe getBaskShoeById(Integer id) {
        return baskShoeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
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
