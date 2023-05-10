// package Order;

// import java.util.ArrayList;
// import java.util.List;

// import User.User;

// public class Order {
// private String orderID;
// private User user;
// private List<OrderItem> items;
// private OrderStatus status;
// private String shippingAddress;
// private PaymentMethod paymentMethod;

// public Order(String orderID, User user) {
// this.orderID = orderID;
// this.user = user;
// this.items = new ArrayList<>();
// this.status = OrderStatus.PENDING;
// }

// public void addItem(Product product, int quantity) {
// OrderItem item = new OrderItem(product, quantity);
// items.add(item);
// }

// public void removeItem(OrderItem item) {
// items.remove(item);
// }

// public double calculateTotalPrice() {
// double totalPrice = 0.0;
// for (OrderItem item : items) {
// double itemPrice = item.getProduct().getPrice();
// double itemDiscount = item.getProduct().getDiscount();
// int itemQuantity = item.getQuantity();
// double itemTotalPrice = itemPrice * itemQuantity * (1 - itemDiscount);
// totalPrice += itemTotalPrice;
// }
// return totalPrice;
// }

// public void updateShippingAddress(String shippingAddress) {
// this.shippingAddress = shippingAddress;
// }

// public void selectPaymentMethod(PaymentMethod paymentMethod) {
// this.paymentMethod = paymentMethod;
// }

// public void placeOrder() {
// // validate order
// if (shippingAddress == null || items.isEmpty()) {
// throw new IllegalStateException("Order cannot be placed without a shipping
// address and items.");
// }

// // select payment method
// if (paymentMethod == null) {
// throw new IllegalStateException("Payment method must be selected before
// placing the order.");
// }

// // set status to processing
// status = OrderStatus.PROCESSING;
// }

// public void closeOrder() {
// if (status != OrderStatus.DELIVERED) {
// throw new IllegalStateException("Order cannot be closed until it has been
// delivered.");
// }

// // mark order as closed
// status = OrderStatus.CLOSED;
// }
// }
