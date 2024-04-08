package com.example.thirdtask.services;

import com.example.thirdtask.constants.Constants;
import com.example.thirdtask.dtos.cartdtos.CartDto;
import com.example.thirdtask.entities.*;
import com.example.thirdtask.exceptions.ForbiddenException;
import com.example.thirdtask.exceptions.NotFoundException;
import com.example.thirdtask.mappers.CartMapper;
import com.example.thirdtask.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartMapper cartMapper;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartMapper cartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartMapper = cartMapper;
    }

    public List<CartDto> getAllShoppingCarts() {
        return shoppingCartRepository.findAll().stream().map(cartMapper::toCartDto).toList();
    }

    public CartDto getShoppingCartById(Integer id) {
        var cart = shoppingCartRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NO_SUCH_ENTITY));
        return cartMapper.toCartDto(cart);
    }

    public void addShoppingCart(ShoppingCart shoppingCart, Integer authenticatedUserId) {
        if (!Objects.equals(authenticatedUserId, shoppingCart.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        shoppingCartRepository.save(shoppingCart);
    }

    public void updateShoppingCart(ShoppingCart shoppingCart, Integer authenticatedUserId) {
        var existingCart = shoppingCartRepository.findById(shoppingCart.getId());

        if (existingCart.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, shoppingCart.getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        shoppingCartRepository.save(shoppingCart);
    }

    public void removeShoppingCartById(Integer id, Integer authenticatedUserId) {
        var existingCart = shoppingCartRepository.findById(id);

        if (existingCart.isEmpty()) {
            throw new NotFoundException(Constants.NO_SUCH_ENTITY);
        }

        if (!Objects.equals(authenticatedUserId, existingCart.get().getUser().getId())) {
            throw new ForbiddenException(Constants.FORBIDDEN);
        }

        shoppingCartRepository.deleteById(id);
    }

    public List<CartDto> getShoppingCartByUserId(Integer userId) {
        return shoppingCartRepository.findByUserId(userId).stream().map(cartMapper::toCartDto).toList();
    }

}
