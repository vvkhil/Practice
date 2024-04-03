package entities;

import java.util.ArrayList;
import java.util.List;

public class ShoesShop {
    private Integer id;
    private String title;
    private Integer rating;
    private Integer userId;
    private List<Integer> baskShoesIds;

    public ShoesShop() {
        this.baskShoesIds = new ArrayList<>();
    }

    public ShoesShop(int id) {
        this.id = id;
        this.baskShoesIds = new ArrayList<>();
    }

    public ShoesShop(int id, String title, int rating, int userId) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.userId = userId;
        this.baskShoesIds = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
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
