package entities;

import java.util.ArrayList;
import java.util.List;

public class Supply {
    private Integer id;
    private Integer userId;
    private List<Integer> baskShoesIds;

    public Supply() {
        this.baskShoesIds = new ArrayList<>();
    }

    public Supply(int id) {
        this.id = id;
        this.baskShoesIds = new ArrayList<>();
    }

    public Supply(int id, int userId) {
        this.id = id;
        this.userId = userId;
        this.baskShoesIds = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
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
