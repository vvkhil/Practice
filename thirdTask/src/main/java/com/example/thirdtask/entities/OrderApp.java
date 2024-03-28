package com.example.thirdtask.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "order_app")
public class OrderApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private BaskShop shop;

    @OneToMany(mappedBy = "orderApp")
    private Set<OrderDescription> orderDescriptions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public BaskShop getShop() {
        return shop;
    }

    public void setShop(BaskShop shop) {
        this.shop = shop;
    }

    public Set<OrderDescription> getOrderDescriptions() {
        return orderDescriptions;
    }

    public void setOrderDescriptions(Set<OrderDescription> orderDescriptions) {
        this.orderDescriptions = orderDescriptions;
    }

}