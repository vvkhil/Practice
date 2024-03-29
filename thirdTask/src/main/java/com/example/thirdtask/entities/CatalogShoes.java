package com.example.thirdtask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalog_shoes")
public class CatalogShoes {
    @EmbeddedId
    private CatalogShoesId id;

    @MapsId("baskShoeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bask_shoe_id", nullable = false)
    private BaskShoe baskShoe;

    @MapsId("shopId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private BaskShop shop;

    public CatalogShoesId getId() {
        return id;
    }

    public void setId(CatalogShoesId id) {
        this.id = id;
    }

    public BaskShoe getBaskShoe() {
        return baskShoe;
    }

    public void setBaskShoe(BaskShoe baskShoe) {
        this.baskShoe = baskShoe;
    }

    public BaskShop getShop() {
        return shop;
    }

    public void setShop(BaskShop shop) {
        this.shop = shop;
    }

}