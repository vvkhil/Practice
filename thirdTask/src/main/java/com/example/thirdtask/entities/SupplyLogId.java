package com.example.thirdtask.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SupplyLogId implements Serializable {
    private static final long serialVersionUID = 1137352969497825926L;
    @Column(name = "bask_shoe_id", nullable = false)
    private Integer baskShoeId;

    @Column(name = "supply_id", nullable = false)
    private Integer supplyId;

    public Integer getBaskShoeId() {
        return baskShoeId;
    }

    public void setBaskShoeId(Integer baskShoeId) {
        this.baskShoeId = baskShoeId;
    }

    public Integer getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || org.springframework.data.util.ProxyUtils.getUserClass(this) != org.springframework.data.util.ProxyUtils.getUserClass(o))
            return false;
        SupplyLogId entity = (SupplyLogId) o;
        return Objects.equals(this.baskShoeId, entity.baskShoeId) &&
                Objects.equals(this.supplyId, entity.supplyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baskShoeId, supplyId);
    }

}