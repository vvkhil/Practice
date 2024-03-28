package com.example.thirdtask.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDescriptionId implements Serializable {
    private static final long serialVersionUID = -8092113929644014053L;
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "status_list_id", nullable = false)
    private Integer statusListId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatusListId() {
        return statusListId;
    }

    public void setStatusListId(Integer statusListId) {
        this.statusListId = statusListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || org.springframework.data.util.ProxyUtils.getUserClass(this) != org.springframework.data.util.ProxyUtils.getUserClass(o))
            return false;
        OrderDescriptionId entity = (OrderDescriptionId) o;
        return Objects.equals(this.statusListId, entity.statusListId) &&
                Objects.equals(this.orderId, entity.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusListId, orderId);
    }

}