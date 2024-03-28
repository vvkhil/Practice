package com.example.thirdtask.entities;

import javax.persistence.*;

@Entity
@Table(name = "catalog_products")
public class CatalogProduct {
    @EmbeddedId
    private CatalogProductId id;

    @javax.persistence.MapsId("baskShoeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bask_shoe_id", nullable = false)
    private BaskShoe baskShoe;

    @javax.persistence.MapsId("shopId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    private BaskShop shop;

    public CatalogProductId getId() {
        return id;
    }

    public void setId(CatalogProductId id) {
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