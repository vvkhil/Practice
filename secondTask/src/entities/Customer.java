package entities;

public class Customer {
    private Integer id;
    private Integer userId;
    private Integer addressId;
    private Integer moneyUser;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, int userId, int addressId, int moneyUser) {
        this.id = id;
        this.userId = userId;
        this.addressId = addressId;
        this.moneyUser = moneyUser;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Integer getMoneyUser() {
        return moneyUser;
    }

}
