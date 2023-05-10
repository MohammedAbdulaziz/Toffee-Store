package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInput {
    public static void getUserInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("1. Register\n2. Login");
        String choice = myObj.next();
        try {
            if (Integer.parseInt(choice) == 1) {
                System.out.print("Enter new username: ");
                String username = myObj.next();
                System.out.print("Enter new password: ");
                String password = myObj.next();
                try {
                    File file = new File("users.txt");
                    Scanner fileScanner = new Scanner(file);

                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split(":");
                        String registeredUsername = parts[0];

                        if (username.equals(registeredUsername)) {
                            System.out.println("Username already exists, please choose another one.");
                            fileScanner.close();
                            getUserInput();
                            return;
                        }
                        fileScanner.close();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                User user = new User(username, password);
                try {
                    FileWriter writer = new FileWriter("users.txt", true);
                    writer.write(user.getUsername() + ":" + user.getPassword() + "\n");
                    writer.close();
                    System.out.println("Registration successful.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Username is: " + user.getUsername() + "\nPassword is: " + user.getPassword());
            } else if (Integer.parseInt(choice) == 2) {
                System.out.print("Enter username: ");
                String username = myObj.next();
                System.out.print("Enter password: ");
                String password = myObj.next();
                try {
                    File file = new File("users.txt");
                    Scanner fileScanner = new Scanner(file);

                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split(":");
                        String registeredUsername = parts[0];
                        String registeredPassword = parts[1];

                        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                            System.out.println("Login successful.");
                            return;
                        }
                        fileScanner.close();
                    }

                    System.out.println("Incorrect username or password.");
                    getUserInput();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                User user = new User(username, password);
                System.out.println("Username is: " + user.getUsername() + "\nPassword is: " + user.getPassword());
            } else {
                System.out.println("Invalid choice");
                getUserInput();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            getUserInput();
        }
    }
}
