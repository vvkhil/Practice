package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.orderdtos.GetOrderDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.OrderMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAppService {
    private final OrderAppRepository orderAppRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderAppService(OrderAppRepository orderAppRepository, OrderMapper orderMapper) {
        this.orderAppRepository = orderAppRepository;
        this.orderMapper = orderMapper;
    }

    public List<GetOrderDto> getAllOrders() {
        return orderAppRepository.findAll().stream().map(orderMapper::orderToGetOrderDto).toList();
    }

    public GetOrderDto getOrderAppById(Integer id) {
        var order = orderAppRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return orderMapper.orderToGetOrderDto(order);
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
