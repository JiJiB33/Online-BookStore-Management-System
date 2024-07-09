package OnlineBookStoreManagementSystem;

import java.util.Scanner;

public class AdminDashboard {

    public void manageUsers(AuthManager authManager, Scanner scanner) {
        while (true) {
            System.out.println("Manage Users:");
            System.out.println("1. View Users");
            System.out.println("2. Add User");
            System.out.println("3. Update User");
            System.out.println("4. Remove User");
            System.out.println("5. Back to Admin Menu");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                viewUsers(authManager);
            } 
            
            else if (choice.equals("2")) {
                addUser(authManager, scanner);
            } 
            
            else if (choice.equals("3")) {
                updateUser(authManager, scanner);
            } 
            
            else if (choice.equals("4")) {
                removeUser(authManager, scanner);
            } 
            
            else if (choice.equals("5")) {
                break;
            } 
            
            else {
            	System.out.println("---------------------------------");
                System.out.println("Invalid choice, please try again.");
            	System.out.println("---------------------------------");
            }
        }
    }

    
    private void viewUsers(AuthManager authManager) {
        System.out.println("Users:");
        for (User user : authManager.getUsers().values()) {
            System.out.println(user);
        }
    }

    
    private void addUser(AuthManager authManager, Scanner scanner) {
    	
        System.out.println("Enter user type (Admin/Seller/Customer):");
        String userType = scanner.nextLine().toLowerCase();
        
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        
        if (userType.equals("admin")) {
            authManager.addUser(new Admin(username, password));
        } 
        
        else if (userType.equals("seller")) {
            authManager.addUser(new Seller(username, password));
        } 
        
        else if (userType.equals("customer")) {
            authManager.addUser(new Customer(username, password));
        } 
        
        else {
        	System.out.println("------------------");
            System.out.println("Invalid user type.");
        	System.out.println("------------------");
        }
    }
    

    private void updateUser(AuthManager authManager, Scanner scanner) {
    	
        System.out.println("Enter username of the user to update:");
        String username = scanner.nextLine();
        
        User user = authManager.getUser(username);
        
        
        if (user != null) {
        	
            System.out.println("Enter new password:");
            String password = scanner.nextLine();
            
            user.setPassword(password);
            
        	System.out.println("-------------");
            System.out.println("User updated.");
        	System.out.println("-------------");
        } 
        
        else {
        	System.out.println("---------------");
            System.out.println("User not found.");
        	System.out.println("---------------");
        }
    }

    private void removeUser(AuthManager authManager, Scanner scanner) {
    	
        System.out.println("Enter username of the user to remove:");
        String username = scanner.nextLine();
        
        authManager.removeUser(username);
        
    	System.out.println("-------------");
        System.out.println("User removed.");
    	System.out.println("-------------");
    }

    public void viewSalesReport(OrderManager orderManager) {
    	
        String report = orderManager.generateSalesReport();
        
        System.out.println("Sales Report:");
        System.out.println(report);
    }

    
    public void manageInventory(InventoryManager inventoryManager) {
    	
        System.out.println("Managing inventory...");
        
        for (Book book : inventoryManager.getBooks()) {
            System.out.println(book);
        }
    }

    public void handleOrders(OrderManager orderManager) {
        System.out.println("Handling orders...");
        
        for (Order order : orderManager.getOrders()) {
            System.out.println(order);
        }
    }

    public void viewCustomerReviews(ReviewRate reviewRate) {
        System.out.println("Customer Reviews:");
        
        for (Review review : reviewRate.getReviews()) {
            System.out.println(review);
        }
    }
}
