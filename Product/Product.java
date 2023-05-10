package Product;

public class Product {
    private String id;
    String name;
    private String category;
    private String description;
    private String image;
    private String brand;
    private double price;
    private double discount;

    public Product(String id, String name, String category, String description, String image, String brand,
            double price, double discount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", this.name, this.brand, this.category);
    }
}
