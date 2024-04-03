package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.cartdtos.GetCartDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.CartMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartMapper cartMapper;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartMapper cartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartMapper = cartMapper;
    }

    public List<GetCartDto> getAllShoppingCarts() {
        return shoppingCartRepository.findAll().stream().map(cartMapper::cartToGetCartDto).toList();
    }

    public GetCartDto getShoppingCartById(Integer id) {
        var cart = shoppingCartRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return cartMapper.cartToGetCartDto(cart);
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    public void updateShoppingCart(ShoppingCart shoppingCart) {
        var existingUser = shoppingCartRepository.findById(shoppingCart.getId());

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        shoppingCartRepository.save(shoppingCart);
    }

    public void removeShoppingCartById(Integer id) {
        var existingUser = shoppingCartRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        shoppingCartRepository.deleteById(id);
    }

}
