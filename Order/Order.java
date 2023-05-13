
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Product.InMemoryProductRepository;
import Product.Product;
import Product.ProductService;

public class Order {
    private static final Map<Product, Integer> cart = new HashMap<>();
    static InMemoryProductRepository productRepo = new InMemoryProductRepository();

    public static void getOrderInput() {
        Scanner productScanner = new Scanner(System.in);
        ProductService productService = new ProductService(new InMemoryProductRepository());
        List<String> products = productService.getCatalog();

        // Display the list of products to the user
        displayProductList(products);

        // Ask the user to choose a product
        Product product = getProductChoice(productScanner, products, productRepo);

        // Get the category and quantity for the chosen product
        String category = getCategory(products, product);
        String quantity = getQuantity(productScanner, category);

        // Add the chosen product and quantity to the cart
        addToCart(products, product, quantity);

        // Ask the user if they want to continue shopping
        boolean continueShopping = askToContinueShopping(productScanner);

        if (continueShopping) {
            // If the user wants to continue shopping, call the getOrderInput() function
            // recursively
            getOrderInput();
        } else {
            // If the user is done shopping, ask for payment method
            getPaymentMethod(productScanner);

            // Display the contents of the cart and thank the user for shopping
            displayCart(cart, productRepo);
            System.out.println("Thank you for shopping with us!");
            System.out.println("Order Delivered");

            productScanner.close();
        }
    }

    private static void displayProductList(List<String> products) {
        System.out.println("Please select a product by entering its number:\n");
        for (String product : products) {
            System.out.println(product);
        }
    }

    private static Product getProductChoice(Scanner productScanner, List<String> products,
            InMemoryProductRepository productRepo) {
        String productChoice = productScanner.next();
        if (Integer.parseInt(productChoice) > products.size()) {
            System.out.println("Invalid choice");
            return getProductChoice(productScanner, products, productRepo);

        }
        String productId = productChoice;
        System.out.println(productId);
        Product product = productRepo.findById(productId);
        System.out.println("You have chosen: " + product.getBrand());
        return product;
    }

    private static String getCategory(List<String> products, Product product) {
        String category = product.getCategory();
        System.out.println("Please enter the quantity in " + category + " you would like to purchase:");
        return category;
    }

    private static String getQuantity(Scanner productScanner, String category) {
        String quantity = productScanner.next();
        System.out.println("You have chosen to purchase " + quantity + " " + category + "s.");
        return quantity;
    }

    private static void addToCart(List<String> products, Product product, String quantity) {
        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            cart.put(product, currentQuantity + Integer.parseInt(quantity));
        } else {
            cart.put(product, Integer.parseInt(quantity));
        }
    }

    private static boolean askToContinueShopping(Scanner productScanner) {
        System.out.println("Would you like to continue shopping? (Y/N)");
        String continueShopping = productScanner.next();
        while (!continueShopping.equalsIgnoreCase("Y") && !continueShopping.equalsIgnoreCase("N")) {
            System.out.println("Please enter Y or N.");
            continueShopping = productScanner.next();
        }
        return continueShopping.equalsIgnoreCase("Y");
    }

    private static void getPaymentMethod(Scanner productScanner) {
        System.out.println("Select payment method:\n1. Cash on Delivery \n2. Credit Card");
        String paymentMethod = productScanner.next();
        if (paymentMethod.equals("1")) {
            System.out.println("You have chosen Cash on Delivery.");
        } else if (paymentMethod.equals("2")) {
            System.out.println("You have chosen Credit Card.");
        } else {
            System.out.println("Invalid response. Please try again.");
            getPaymentMethod(productScanner);
        }
    }

    private static void displayCart(Map<Product, Integer> cart, InMemoryProductRepository productRepo) {
        System.out.println("Your cart contains:");
        double total = 0.0;
        for (Product product : cart.keySet()) {
            int productQuantity = cart.get(product);
            double productPrice = product.getPrice();
            System.out.println(product.getBrand() + " x " + productQuantity + " at " + productPrice + " each");
            total += productPrice * productQuantity;
        }
        System.out.println("Total price: " + total);
    }

}
