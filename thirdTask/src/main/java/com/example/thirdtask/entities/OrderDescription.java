package com.example.thirdtask.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "order_description")
public class OrderDescription {
    @EmbeddedId
    private OrderDescriptionId id;

    @javax.persistence.MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderApp order;

    @javax.persistence.MapsId("statusListId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_list_id", nullable = false)
    private StatusList statusList;

    @Column(name = "waiting_time")
    private Instant waitingTime;

    public OrderDescriptionId getId() {
        return id;
    }

    public void setId(OrderDescriptionId id) {
        this.id = id;
    }

    public OrderApp getOrder() {
        return order;
    }

    public void setOrder(OrderApp order) {
        this.order = order;
    }

    public StatusList getStatusList() {
        return statusList;
    }

    public void setStatusList(StatusList statusList) {
        this.statusList = statusList;
    }

    public Instant getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Instant waitingTime) {
        this.waitingTime = waitingTime;
    }

}