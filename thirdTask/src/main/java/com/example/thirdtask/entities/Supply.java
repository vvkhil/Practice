package com.example.thirdtask.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @ManyToMany()
    @JoinTable(name="supply_log",
            joinColumns=@JoinColumn(name="supply_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="bask_shoe_id", referencedColumnName="id"))
    private List<BaskShoe> baskShoe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

//    public Set<BaskShoe> getBaskShoes() {
//        return baskShoes;
//    }
//
//    public void setBaskShoes(Set<BaskShoe> baskShoes) {
//        this.baskShoes = baskShoes;
//    }

}