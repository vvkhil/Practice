package com.example.thirdtask.entities;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany()
    @JoinTable(name="bask_cart",
            joinColumns=@JoinColumn(name="shopping_Cart_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="bask_Shoe_id", referencedColumnName="id"))
    private List<BaskShoe> baskShoe;

    @OneToMany(mappedBy = "shoppingCart")
    private Set<OrderApp> orderApps = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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