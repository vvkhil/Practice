package com.example.thirdtask.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "house", length = 20)
    private String house;

    @Column(name = "flat", length = 10)
    private String flat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserApp userApp;

}