package entities;

public class Address {
    private Integer id;
    private String city;
    private String street;
    private String house;
    private String flat;
    private Integer userId;

    public Address(int id) {
        this.id = id;
    }

    public Address(int id, String city, String street, String house, String flat, int userId) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlat() {
        return flat;
    }

    public Integer getUserId() {
        return userId;
    }

}
