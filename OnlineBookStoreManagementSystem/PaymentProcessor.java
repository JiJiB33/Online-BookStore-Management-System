package OnlineBookStoreManagementSystem;

import java.util.Scanner;

public class PaymentProcessor {

    public boolean processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a payment method:");
        System.out.println("1. Credit Card/Visa");
        System.out.println("2. PayPal");
        System.out.println("3. Mobile Banking");
        System.out.println("4. KBZ Pay");
        System.out.println("5. WaveMoney");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return processCreditCard(amount, scanner);
            case "2":
                return processPayPal(amount, scanner);
            case "3":
                return processMobileBanking(amount, scanner);
            case "4":
                return processKBZPay(amount, scanner);
            case "5":
                return processWaveMoney(amount, scanner);
            default:
                System.out.println("****Invalid payment method.*****");
                return false;
        }
    }

    private boolean processCreditCard(double amount, Scanner scanner) {
    	
        System.out.println("Enter credit card number:");
        String cardNumber = scanner.nextLine();
        
        System.out.println("Enter expiration date (MM/YY):");
        String expirationDate = scanner.nextLine();
        
        System.out.println("Enter CVV:");
        String cvv = scanner.nextLine();
        
        System.out.println("----------------------------------------------");
        System.out.println("Processing credit card payment of " + amount + " MMK...");
        System.out.println("----------------------------------------------");
        
        return true;
    }

    
    private boolean processPayPal(double amount, Scanner scanner) {
    	
        System.out.println("Enter PayPal email:");
        String email = scanner.nextLine();
        
        System.out.println("Enter PayPal password:");
        String password = scanner.nextLine();
        
        System.out.println("----------------------------------------------");
        System.out.println("Processing PayPal payment of " + amount + " MMK...");
        System.out.println("----------------------------------------------");
        
        return true;
    }
    

    private boolean processMobileBanking(double amount, Scanner scanner) {
    	
        System.out.println("Enter mobile banking account number:");
        String accountNumber = scanner.nextLine();
        
        System.out.println("----------------------------------------------");
        System.out.println("Processing mobile banking payment of " + amount + " MMK...");
        System.out.println("----------------------------------------------");
        
        return true;
    }

    
    private boolean processKBZPay(double amount, Scanner scanner) {
    	
        System.out.println("Enter KBZ Pay phone number:");
        String phoneNumber = scanner.nextLine();
        
        System.out.println("----------------------------------------------");
        System.out.println("Processing KBZ Pay payment of " + amount + " MMK...");
        System.out.println("----------------------------------------------");
        
        return true;
    }
    

    private boolean processWaveMoney(double amount, Scanner scanner) {
        System.out.println("Enter WaveMoney phone number:");
        String phoneNumber = scanner.nextLine();
        
        System.out.println("----------------------------------------------");
        System.out.println("Processing WaveMoney payment of " + amount + " MMK...");
        System.out.println("----------------------------------------------");
        
        return true;
    }
}
