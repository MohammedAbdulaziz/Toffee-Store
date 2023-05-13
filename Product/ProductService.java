package Product;

import java.util.List;

public class ProductService {
  private InMemoryProductRepository productRepository;

  public ProductService(InMemoryProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<String> getCatalog() {
    return productRepository.findAllFormatted();
  }

  public Product getProductById(String id) {
    return productRepository.findById(id);
  }

  public Product getProductByName(String name) {
    return productRepository.findByName(name);
  }
}
