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
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserApp user;

    @ManyToMany()
    @JoinTable(name="bask_cart",
            joinColumns=@JoinColumn(name="shopping_Cart_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="bask_Shoe_id", referencedColumnName="id"))
    private Set<BaskShoe> shoe = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cart")
    private Set<OrderApp> order = new LinkedHashSet<>();

}