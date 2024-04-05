package com.example.thirdtask.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserApp user;

    @ManyToMany()
    @JoinTable(name="catalog_shoes",
            joinColumns=@JoinColumn(name="shop_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="bask_shoe_id", referencedColumnName="id"))
    private Set<BaskShoe> shoe = new LinkedHashSet<>();

    @OneToMany(mappedBy = "shop")
    private Set<OrderApp> order = new LinkedHashSet<>();


}