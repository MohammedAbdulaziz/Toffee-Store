package Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(String name);
}
