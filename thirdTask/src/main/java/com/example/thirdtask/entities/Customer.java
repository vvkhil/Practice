package com.example.thirdtask.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserApp user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "money_user")
    private Integer moneyUser;

//    @OneToMany(mappedBy = "customer")
//    private Set<ShoppingCart> shoppingCarts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getMoneyUser() {
        return moneyUser;
    }

    public void setMoneyUser(Integer moneyUser) {
        this.moneyUser = moneyUser;
    }

//    public Set<ShoppingCart> getShoppingCarts() {
//        return shoppingCarts;
//    }
//
//    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
//        this.shoppingCarts = shoppingCarts;
//    }

}