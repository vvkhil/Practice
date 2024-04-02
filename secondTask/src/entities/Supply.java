package entities;

import java.util.ArrayList;
import java.util.List;

public class Supply {
    private Integer id;
    private Integer providerId;
    private List<Integer> baskShoesIds;

    public Supply() {
        this.baskShoesIds = new ArrayList<>();
    }

    public Supply(int id) {
        this.id = id;
        this.baskShoesIds = new ArrayList<>();
    }

    public Supply(int id, int providerId) {
        this.id = id;
        this.providerId = providerId;
        this.baskShoesIds = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void addBaskShoes(Integer baskShoesId) {
        this.baskShoesIds.add(baskShoesId);
    }

    public void removeBaskShoes(Integer baskShoesId) {
        this.baskShoesIds.remove(baskShoesId);
    }

    public List<Integer> getBaskShoes() {
        return baskShoesIds;
    }

}
