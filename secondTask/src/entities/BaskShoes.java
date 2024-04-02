package entities;

public class BaskShoes {
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private String manufacturer;
    private String brand;
    private Integer size;


    public BaskShoes(int id) {
        this.id = id;
    }

    public BaskShoes(int id, String title, String description, int price,
                     String manufacturer, String brand, int size) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getSize() {
        return size;
    }

}
