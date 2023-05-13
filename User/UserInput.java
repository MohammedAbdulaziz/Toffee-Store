package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInput {
    public static void getUserInput() {
        Scanner myObj = new Scanner(System.in);

        // Ask the user to register or login
        System.out.println("1. Register\n2. Login");
        String choice = myObj.next();

        try {
            if (Integer.parseInt(choice) == 1) {
                // If the user chose to register, call the register function
                register(myObj);

            } else if (Integer.parseInt(choice) == 2) {
                // If the user chose to login, call the login function
                login(myObj);

            } else {
                // If the user entered an invalid choice, prompt again
                System.out.println("Invalid choice");
                getUserInput();
            }

        } catch (NumberFormatException e) {
            // If the user entered an invalid choice, prompt again
            System.out.println("Invalid choice");
            getUserInput();
        }
    }

    private static void register(Scanner myObj) {
        // Ask for a new username and password
        System.out.print("Enter new username: ");
        String username = myObj.next();
        System.out.print("Enter new password: ");
        String password = myObj.next();

        try {
            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);

            // Check if the username is already taken
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(":");
                String registeredUsername = parts[0];

                if (username.equals(registeredUsername)) {
                    System.out.println("Username already exists, please choose another one.");
                    register(myObj);
                    return;
                }
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // If the username is available, create a new User object and write it to the
        // file
        User user = new User(username, password);
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(user.getUsername() + ":" + user.getPassword() + "\n");
            writer.close();
            System.out.println("Registration successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean login(Scanner myObj) {
        // Ask for a username and password
        System.out.print("Enter username: ");
        String username = myObj.next();
        System.out.print("Enter password: ");
        String password = myObj.next();
        boolean userExists = false;

        try {
            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);

            // Check if the username and password match a registered user
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(":");
                String registeredUsername = parts[0];
                String registeredPassword = parts[1];

                if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                    System.out.println("Login successful.");
                    userExists = true;
                    break;
                } else if ((username.equals(registeredUsername) && !password.equals(registeredPassword))) {
                    System.out.println("Incorrect username or password. Please try again.");
                    userExists = login(myObj);
                }
            }
            // If the username and password don't match a registered user, prompt to
            // register
            if (!userExists) {
                System.out.println("User doesn't exist. Please register a new user.");
                register(myObj);
            }
            fileScanner.close();
            return userExists;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}