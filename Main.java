import java.util.List;
import Product.InMemoryProductRepository;
import Product.ProductService;
import User.UserInput;

public class Main {

    public static void main(String[] args) {
        UserInput.getUserInput();
        ProductService productService = new ProductService(new InMemoryProductRepository());
        List<String> products = productService.getCatalog();
        for (String product : products) {
            System.out.println(product);
        }

    }

}
