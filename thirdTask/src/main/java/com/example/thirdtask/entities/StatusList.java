package com.example.thirdtask.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "status_list")
public class StatusList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status_name", length = 50)
    private String statusName;

    @OneToMany(mappedBy = "statusList")
    private Set<OrderDescription> orderDescriptions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Set<OrderDescription> getOrderDescriptions() {
        return orderDescriptions;
    }

    public void setOrderDescriptions(Set<OrderDescription> orderDescriptions) {
        this.orderDescriptions = orderDescriptions;
    }

}