package com.example.thirdtask.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "supply_log")
public class SupplyLog {
    @EmbeddedId
    private SupplyLogId id;

    @MapsId("baskShoeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bask_shoe_id", nullable = false)
    private BaskShoe baskShoe;

    @MapsId("supplyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supply_id", nullable = false)
    private Supply supply;

    public SupplyLogId getId() {
        return id;
    }

    public void setId(SupplyLogId id) {
        this.id = id;
    }

    public BaskShoe getBaskShoe() {
        return baskShoe;
    }

    public void setBaskShoe(BaskShoe baskShoe) {
        this.baskShoe = baskShoe;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

}