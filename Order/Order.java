
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Product.InMemoryProductRepository;
import Product.ProductService;

public class Order {
    private static final Map<String, Integer> cart = new HashMap<>();

    public static void getOrderInput() {
        Scanner productScanner = new Scanner(System.in);
        ProductService productService = new ProductService(new InMemoryProductRepository());
        List<String> products = productService.getCatalog();

        // Display the list of products to the user
        displayProductList(products);

        // Ask the user to choose a product
        String productChoice = getProductChoice(productScanner, products);

        // Get the category and quantity for the chosen product
        String category = getCategory(products, productChoice);
        String quantity = getQuantity(productScanner, category);

        // Add the chosen product and quantity to the cart
        addToCart(products, productChoice, quantity);

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
            displayCart(cart);
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

    private static String getProductChoice(Scanner productScanner, List<String> products) {
        String productChoice = productScanner.next();
        if (Integer.parseInt(productChoice) > products.size()) {
            System.out.println("Invalid choice");
            return getProductChoice(productScanner, products);

        }
        System.out.println("You have chosen: " + products.get(Integer.parseInt(productChoice) - 1).substring(3));
        return productChoice;
    }

    private static String getCategory(List<String> products, String productChoice) {
        String[] parts = products.get(Integer.parseInt(productChoice) - 1).split("[()]");
        String category = parts[1].trim();
        System.out.println("Please enter the quantity in " + category + " you would like to purchase:");
        return category;
    }

    private static String getQuantity(Scanner productScanner, String category) {
        String quantity = productScanner.next();
        System.out.println("You have chosen to purchase " + quantity + " " + category + "s.");
        return quantity;
    }

    private static void addToCart(List<String> products, String productChoice, String quantity) {
        String productName = products.get(Integer.parseInt(productChoice) - 1).substring(3);
        if (cart.containsKey(productName)) {
            int currentQuantity = cart.get(productName);
            cart.put(productName, currentQuantity + Integer.parseInt(quantity));
        } else {
            cart.put(productName, Integer.parseInt(quantity));
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

    private static void displayCart(Map<String, Integer> cart) {
        System.out.println("Your cart contains:");
        for (String product : cart.keySet()) {
            int productQuantity = cart.get(product);
            System.out.println(product + " x " + productQuantity);
        }
    }
}
