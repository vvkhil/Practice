package com.example.thirdtask.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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

    @ManyToMany(mappedBy = "shoe")
    private List<ShoppingCart> shoppingCarts;

    @ManyToMany(mappedBy = "shoe")
    private List<BaskShop> baskShops;

    @ManyToMany(mappedBy = "shoe")
    private List<Supply> supplies;

}