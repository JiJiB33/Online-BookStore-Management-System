package OnlineBookStoreManagementSystem;

public class Order {
    private Cart cart;
    private Customer customer;
    private String customerName;
    private String address;
    private double totalAmount;

    public Order(Cart cart, Customer customer, String customerName, String address, double totalAmount) {
        this.cart = cart;
        this.customer = customer;
        this.customerName = customerName;
        this.address = address;
        this.totalAmount = totalAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\nOrder Details:\n")
          .append("Customer Name: ").append(customerName).append("\n")
          .append("Address: ").append(address).append("\n")
          .append("Total Amount: ").append(totalAmount).append(" MMK\n")
          .append("------------------------------------------\nCart Items:\n");

        for (CartItem item : cart.getItems()) {
            sb.append(item).append("\n");
        }

        return sb.toString();
    }
}
