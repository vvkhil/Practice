package com.example.thirdtask.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_app")
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_app_id", nullable = false)
    private Integer id;

    @Column(name = "login", length = 50)
    private String login;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 50)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ShoppingCart> shoppingCarts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Supply> supplies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<BaskShop> baskShops = new LinkedHashSet<>();

}