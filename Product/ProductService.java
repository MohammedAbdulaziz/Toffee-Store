package Product;

import java.util.List;

public class ProductService {
  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getCatalog() {
    return productRepository.findAll();
  }

  public Product getProductById(String id) {
    return productRepository.findById(id);
  }
}
