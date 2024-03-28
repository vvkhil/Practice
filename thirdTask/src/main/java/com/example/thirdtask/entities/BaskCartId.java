package com.example.thirdtask.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BaskCartId implements Serializable {
    private static final long serialVersionUID = 3583148149909249588L;
    @Column(name = "bask_shoe_id", nullable = false)
    private Integer baskShoeId;

    @Column(name = "shopping_cart_id", nullable = false)
    private Integer shoppingCartId;

    public Integer getBaskShoeId() {
        return baskShoeId;
    }

    public void setBaskShoeId(Integer baskShoeId) {
        this.baskShoeId = baskShoeId;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || org.springframework.data.util.ProxyUtils.getUserClass(this) != org.springframework.data.util.ProxyUtils.getUserClass(o))
            return false;
        BaskCartId entity = (BaskCartId) o;
        return Objects.equals(this.baskShoeId, entity.baskShoeId) &&
                Objects.equals(this.shoppingCartId, entity.shoppingCartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baskShoeId, shoppingCartId);
    }

}