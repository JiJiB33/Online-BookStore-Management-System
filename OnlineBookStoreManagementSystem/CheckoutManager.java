package OnlineBookStoreManagementSystem;

import java.util.Scanner;

public class CheckoutManager {

    private PaymentProcessor paymentProcessor;

    public CheckoutManager() {
        paymentProcessor = new PaymentProcessor();
    }

    public void checkout(Cart cart, Customer customer, OrderManager orderManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter your address (House.no, Road, City):");
        String address = scanner.nextLine();

        double totalAmount = cart.getTotal();
        System.out.println("************************************");
        System.out.println("Total amount to be paid: " + totalAmount + " MMK");
        System.out.println("************************************");

        boolean paymentSuccessful = paymentProcessor.processPayment(totalAmount);
        
        
        if (paymentSuccessful) {
        	
            System.out.println("Payment successful. Thank you for your purchase, " + customerName + "!");
            System.out.println("---------------------------------------------------------------");

            Order order = new Order(cart, customer, customerName, address, totalAmount);
            
            orderManager.addOrder(order);
            
            // Empty cart after checkout
            cart.getItems().clear();
            
        } 
        
        else {
            System.out.println("---------------------------------");
            System.out.println("Payment failed. Please try again.");
            System.out.println("---------------------------------");
        }
    }
}
