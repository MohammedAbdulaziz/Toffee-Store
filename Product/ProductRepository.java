package Product;

import java.util.List;

public interface ProductRepository {
    List<String> findAllFormatted();

    Product findById(String name);
}
