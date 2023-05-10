package Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductInput {
    private static final Map<String, Integer> cart = new HashMap<>();

    public static void getProductInput() {
        Scanner productScanner = new Scanner(System.in);
        ProductService productService = new ProductService(new InMemoryProductRepository());
        List<String> products = productService.getCatalog();
        System.out.println("Please select a product by entering its number:\n");
        for (String product : products) {
            System.out.println(product);
        }
        String productChoice = productScanner.next();
        System.out.println("You have chosen: " + products.get(Integer.parseInt(productChoice) - 1).substring(3));
        String[] parts = products.get(Integer.parseInt(productChoice) - 1).split("[()]");
        String category = parts[1].trim();
        System.out.println("Please enter the quantity in " + category + " you would like to purchase:");
        String quantity = productScanner.next();
        System.out.println("You have chosen to purchase " + quantity + " " + category + "s.");
        if (cart.containsKey(products.get(Integer.parseInt(productChoice) - 1).substring(3))) {
            int currentQuantity = cart.get(products.get(Integer.parseInt(productChoice) - 1).substring(3));
            cart.put(products.get(Integer.parseInt(productChoice) - 1).substring(3),
                    currentQuantity + Integer.parseInt(quantity));
        } else {
            cart.put(products.get(Integer.parseInt(productChoice) - 1).substring(3), Integer.parseInt(quantity));
        }
        System.out.println("Would you like to continue shopping? (Y/N)");
        String continueShopping = productScanner.next();
        if (continueShopping.equals("Y") || continueShopping.equals("y")) {
            getProductInput();
            productScanner.close();
            return;
        } else if (continueShopping.equals("N") || continueShopping.equals("n")) {
            System.out.println("Select payment method:\n1. Cash on Delivery \n2. Credit Card");
            String paymentMethod = productScanner.next();
            if (paymentMethod.equals("1")) {
                System.out.println("You have chosen Cash on Delivery.");
            } else if (paymentMethod.equals("2")) {
                System.out.println("You have chosen Credit Card.");
            }
        }
        System.out.println("Your cart contains:");
        for (String product : cart.keySet()) {
            int productQuantity = cart.get(product);
            System.out.println(product + " x " + productQuantity);
        }
        System.out.println("Thank you for shopping with us!");
        System.out.println("Order Delivered");
        productScanner.close();
    }
}
