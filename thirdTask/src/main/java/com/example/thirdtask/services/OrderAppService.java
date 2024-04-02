package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAppService {
    private final OrderAppRepository orderAppRepository;

    @Autowired
    public OrderAppService(OrderAppRepository orderAppRepository) {
        this.orderAppRepository = orderAppRepository;
    }

    public List<OrderApp> getAllOrders() {
        return orderAppRepository.findAll();
    }

    public OrderApp getOrderAppById(Integer id) {
        return orderAppRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
    }

    public void addOrderApp(OrderApp orderApp) {
        orderAppRepository.save(orderApp);
    }

    public void updateOrderApp(OrderApp orderApp) {
        var existingUser = orderAppRepository.findById(orderApp.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        orderAppRepository.save(orderApp);
    }

    public void removeOrderAppById(Integer id) {
        var existingUser = orderAppRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        orderAppRepository.deleteById(id);
    }

}
