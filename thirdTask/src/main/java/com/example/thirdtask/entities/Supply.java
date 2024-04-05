package com.example.thirdtask.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "supply")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserApp user;

    @ManyToMany()
    @JoinTable(name="supply_log",
            joinColumns=@JoinColumn(name="supply_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="bask_shoe_id", referencedColumnName="id"))
    private Set<BaskShoe> shoe = new LinkedHashSet<>();

}