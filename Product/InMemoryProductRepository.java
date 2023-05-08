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
        Product product1 = new Product("1", "Product 1", "Category 1", "Description 1", "image1.jpg", "Brand 1", 10.0,
                0.0);
        Product product2 = new Product("2", "Product 2", "Category 2", "Description 2", "image2.jpg", "Brand 2", 20.0,
                0.0);
        Product product3 = new Product("3", "Product 3", "Category 3", "Description 3", "image3.jpg", "Brand 3", 30.0,
                0.0);
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
