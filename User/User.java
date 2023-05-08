package User;

import java.util.List;

import Order.Order;

public class User {
    private String email;
    private String password;
    private String address;
    private int loyaltyPoints;

    public User(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.loyaltyPoints = 0;
    }

    // getters and setters for email, password, address, and loyaltyPoints

    public void updateProfile(String address) {
        this.address = address;
    }

    public void placeOrder(Order order) {
        // implementation
    }

    public void applyLoyaltyPoints(int points) {
        // implementation
    }

    public List<Order> viewOrderHistory() {
        return null;
        // implementation
    }

    public String getPassword() {
        return password;
    }
}