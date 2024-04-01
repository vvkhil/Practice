package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.entities.Address;
import com.example.thirdtask.entities.AdminShop;
import com.example.thirdtask.entities.UserApp;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.repositories.AddressRepository;
import com.example.thirdtask.repositories.AdminShopRepository;
import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminShopService {
    @Autowired
    private AdminShopRepository adminShopRepository;

    public List<AdminShop> getAllAdmins() {
        return adminShopRepository.findAll();
    }

    public AdminShop getAdminById(Integer id) {
        return adminShopRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
    }

    public void addAdmin(AdminShop adminShop) {
        adminShopRepository.save(adminShop);
    }

    public void updateAdmin(AdminShop adminShop) {
        var existingUser = adminShopRepository.findById(adminShop.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        adminShopRepository.save(adminShop);
    }

    public void removeAdminById(Integer id) {
        var existingUser = adminShopRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        adminShopRepository.deleteById(id);
    }

}
