package com.example.thirdtask.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
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

//    @ManyToMany(mappedBy = "supplies")
//    private Set<BaskShoe> baskShoes = new LinkedHashSet<>();

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