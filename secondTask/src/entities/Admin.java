package entities;

public class Admin {
    private Integer id;
    private Integer userId;
    private Integer shopId;

    public Admin(int id) {
        this.id = id;
    }

    public Admin(int id, int userId, int shopId) {
        this.id = id;
        this.userId = userId;
        this.shopId = shopId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getShopId() {
        return shopId;
    }

}
