package com.example.thirdtask.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CatalogProductId implements Serializable {
    private static final long serialVersionUID = 1159001007234282108L;
    @Column(name = "bask_shoe_id", nullable = false)
    private Integer baskShoeId;

    @Column(name = "shop_id", nullable = false)
    private Integer shopId;

    public Integer getBaskShoeId() {
        return baskShoeId;
    }

    public void setBaskShoeId(Integer baskShoeId) {
        this.baskShoeId = baskShoeId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || org.springframework.data.util.ProxyUtils.getUserClass(this) != org.springframework.data.util.ProxyUtils.getUserClass(o))
            return false;
        CatalogProductId entity = (CatalogProductId) o;
        return Objects.equals(this.baskShoeId, entity.baskShoeId) &&
                Objects.equals(this.shopId, entity.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baskShoeId, shopId);
    }

}