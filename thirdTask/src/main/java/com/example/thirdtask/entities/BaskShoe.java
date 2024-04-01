package com.example.thirdtask.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bask_shoe")
public class BaskShoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "manufacturer", length = 50)
    private String manufacturer;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "size", nullable = false)
    private Integer size;

    @ManyToMany(mappedBy = "baskShoe")
    private List<ShoppingCart> shoppingCarts;

    @ManyToMany(mappedBy = "baskShoe")
    private List<BaskShop> baskShops;

    @ManyToMany(mappedBy = "baskShoe")
    private List<Supply> supplies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

//    public Set<ShoppingCart> getShoppingCarts() {
//        return shoppingCarts;
//    }
//
//    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
//        this.shoppingCarts = shoppingCarts;
//    }
//
//    public Set<BaskShop> getBaskShops() {
//        return baskShops;
//    }
//
//    public void setBaskShops(Set<BaskShop> baskShops) {
//        this.baskShops = baskShops;
//    }
//
//    public Set<Supply> getSupplies() {
//        return supplies;
//    }
//
//    public void setSupplies(Set<Supply> supplies) {
//        this.supplies = supplies;
//    }

}