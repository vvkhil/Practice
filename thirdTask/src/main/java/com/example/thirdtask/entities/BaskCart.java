package com.example.thirdtask.entities;

import javax.persistence.*;

@Entity
@Table(name = "bask_cart")
public class BaskCart {
    @EmbeddedId
    private BaskCartId id;

    @javax.persistence.MapsId("baskShoeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bask_shoe_id", nullable = false)
    private BaskShoe baskShoe;

    @javax.persistence.MapsId("shoppingCartId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;

    public BaskCartId getId() {
        return id;
    }

    public void setId(BaskCartId id) {
        this.id = id;
    }

    public BaskShoe getBaskShoe() {
        return baskShoe;
    }

    public void setBaskShoe(BaskShoe baskShoe) {
        this.baskShoe = baskShoe;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

}