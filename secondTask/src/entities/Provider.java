package entities;

public class Provider {
    private Integer id;
    private Integer userId;

    public Provider(int id) {
        this.id = id;
    }

    public Provider(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

}
