package Product;

import java.util.List;

public class ProductService {
  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<String> getCatalog() {
    return productRepository.findAllFormatted();
  }

  public Product getProductById(String id) {
    return productRepository.findById(id);
  }
}
