import java.util.List;
import java.util.Scanner;

import Product.InMemoryProductRepository;
import Product.ProductService;
import User.UserInput;

public class Main {

    public static void main(String[] args) {
        UserInput.getUserInput();
        Scanner productScanner = new Scanner(System.in);
        ProductService productService = new ProductService(new InMemoryProductRepository());
        List<String> products = productService.getCatalog();
        System.out.println("Please se1lect a product by entering its number:\n");
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
        System.out.println("Would you like to continue shopping? (Y/N)");
        String continueShopping = productScanner.next();
        if (continueShopping.equals("Y") || continueShopping.equals("y")) {
            main(args);
        } else if (continueShopping.equals("N") || continueShopping.equals("n")) {
            System.out.println("Select payment method:\n1. Cash on Delivery \n2. Credit Card");
            String paymentMethod = productScanner.next();
            if (paymentMethod.equals("1")) {
                System.out.println("You have chosen Cash on Delivery.");
            } else if (paymentMethod.equals("2")) {
                System.out.println("You have chosen Credit Card.");
            }
        }
        System.out.println(
                "Your cart contains:\n" + products.get(Integer.parseInt(productChoice) - 1).substring(3) + " x "
                        + quantity + "\n");
        System.out.println("Thank you for shopping with us!");
        productScanner.close();

    }

}
