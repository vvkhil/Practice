package com.example.thirdtask.entities;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bask_shop")
public class BaskShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "shop")
    private Set<AdminShop> adminShops = new LinkedHashSet<>();

    @ManyToMany()
    @JoinTable(name="catalog_shoes",
            joinColumns=@JoinColumn(name="shop_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="bask_shoe_id", referencedColumnName="id"))
    private List<BaskShoe> baskShoe;

    @OneToMany(mappedBy = "shop")
    private Set<OrderApp> orderApps = new LinkedHashSet<>();

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Set<AdminShop> getAdminShops() {
        return adminShops;
    }

    public void setAdminShops(Set<AdminShop> adminShops) {
        this.adminShops = adminShops;
    }

//    public Set<BaskShoe> getBaskShoes() {
//        return baskShoes;
//    }
//
//    public void setBaskShoes(Set<BaskShoe> baskShoes) {
//        this.baskShoes = baskShoes;
//    }

    public Set<OrderApp> getOrderApps() {
        return orderApps;
    }

    public void setOrderApps(Set<OrderApp> orderApps) {
        this.orderApps = orderApps;
    }

}