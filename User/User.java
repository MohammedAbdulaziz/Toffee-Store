package User;

import java.util.List;

import Order.Order;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void updateProfile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void placeOrder(Order order) {
        // implementation
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}