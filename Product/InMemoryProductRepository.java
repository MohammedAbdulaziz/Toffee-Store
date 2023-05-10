package Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {
    private Map<String, Product> products;

    public InMemoryProductRepository() {
        this.products = new HashMap<>();
        // initialize some products
        Product product1 = new Product("1", "Candy", "Package",
                "A sealed package full of different candies including hard candy and many other types.", "image1.jpg",
                "Hershi", 5.0,
                3.0);
        Product product2 = new Product("2", "Chocolate", "Kilo", "Solidified Milk Chocolate sold in kilos",
                "image2.jpg", "Milka", 20.0,
                5.0);
        Product product3 = new Product("3", "Toffee", "Kilo", "Toffee sold in kilos", "image3.jpg", "Toffifay", 30.0,
                5.0);
        this.products.put("1", product1);
        this.products.put("2", product2);
        this.products.put("3", product3);
    }

    public List<Product> findAll() {
        return new ArrayList<>(this.products.values());
    }

    public Product findById(String id) {
        return this.products.get(id);
    }
}
