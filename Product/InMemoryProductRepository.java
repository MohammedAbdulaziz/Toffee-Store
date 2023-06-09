package Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProductRepository implements ProductRepository {
    private Map<String, Product> products;

    public InMemoryProductRepository() {
        this.products = new HashMap<>();
        initializeProducts();
    }

    // Initialize some sample products
    private void initializeProducts() {
        Product product1 = new Product("1", "Candy", "Package",
                "A sealed package full of different candies including\n hard candy and many other types.", "image1.jpg",
                "Hershi", 5.0, 3.0);
        Product product2 = new Product("2", "Chocolate", "Kilo", "Solidified Milk Chocolate sold in kilos",
                "image2.jpg", "Milka", 20.0, 5.0);
        Product product3 = new Product("3", "Toffee", "Kilo", "Toffee sold in kilos", "image3.jpg", "Toffifay", 30.0,
                5.0);
        this.products.put("1", product1);
        this.products.put("2", product2);
        this.products.put("3", product3);
    }

    // Return a list of formatted product strings
    public List<String> findAllFormatted() {
        List<String> formattedProducts = new ArrayList<>();
        int i = 1;
        for (Product product : this.products.values()) {
            String formattedProduct = i + ". " + product.getName() + " - " + product.getBrand() + " (" +
                    product.getCategory() + ")\n  " + product.getDescription() + "\n  Price: " + product.getPrice();
            formattedProducts.add(formattedProduct);
            i++;
        }
        return formattedProducts;
    }

    // Return the product with the given id
    public Product findById(String string) {
        return this.products.get(string);
    }

    public Product findByName(String name) {
        for (Product product : this.products.values()) {
            if (product.getName().equals(name)) {
                System.out.println("Found product: " + product.getName());
                return product;
            }
        }
        return null;
    }
}