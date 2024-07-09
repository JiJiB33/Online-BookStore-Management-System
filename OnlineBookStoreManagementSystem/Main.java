package OnlineBookStoreManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthManager authManager = new AuthManager();
        InventoryManager inventoryManager = new InventoryManager();
        OrderManager orderManager = new OrderManager();
        ReviewRate reviewRate = new ReviewRate();
        AdminDashboard adminDashboard = new AdminDashboard();

        // Initialize sample data
        SampleDataInitializer.initialize(inventoryManager);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************");
            System.out.println("Choose user type:");
            System.out.println("1. Admin");
            System.out.println("2. Seller");
            System.out.println("3. Customer");
            System.out.println("4. Exit");
            System.out.println("**********************");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                authenticateAndHandleAdmin(authManager, inventoryManager, orderManager, adminDashboard, reviewRate, scanner);
            } 
            
            else if (choice.equals("2")) {
                authenticateAndHandleSeller(authManager, inventoryManager, scanner);
            } 
            
            else if (choice.equals("3")) {
                authenticateAndHandleCustomer(authManager, inventoryManager, orderManager, reviewRate, scanner);
            } 
            
            else if (choice.equals("4")) {
                System.out.println("--------------------");
                System.out.println("Exiting...");
                System.out.println("--------------------");
                break;
            } 
            
            else {
                System.out.println("---------------------------------");
                System.out.println("Invalid choice, please try again.");
                System.out.println("---------------------------------");
            }
        }
    }

    private static void authenticateAndHandleAdmin(AuthManager authManager, InventoryManager inventoryManager, OrderManager orderManager, AdminDashboard adminDashboard, ReviewRate reviewRate, Scanner scanner) {
        User admin = null;
        
        for (int i = 0; i < 3; i++) {
        	
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            
            admin = authManager.authenticate(username, password);
            
            if (admin instanceof Admin) {
                handleAdmin(authManager, inventoryManager, orderManager, adminDashboard, reviewRate, scanner);
                break;
                
            } 
            
            else if (i < 2) {
            	System.out.println("--------------------------------------");
                System.out.println("Wrong Username or Password. Try again.");
                System.out.println("--------------------------------------");
            }
        }
    }

    
    private static void authenticateAndHandleSeller(AuthManager authManager, InventoryManager inventoryManager, Scanner scanner) {
        
    	System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        User seller = authManager.authenticate(username, password);
        
        if (seller instanceof Seller) {
            handleSeller(authManager, inventoryManager, scanner);
        } 
        
        else {
            System.out.println("--------------------------------------");
            System.out.println("Wrong Username or Password. Try again.");
            System.out.println("--------------------------------------");
        }
    }

    
    private static void authenticateAndHandleCustomer(AuthManager authManager, InventoryManager inventoryManager, OrderManager orderManager, ReviewRate reviewRate, Scanner scanner) {
       
    	System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        User customer = authManager.authenticate(username, password);
        
        if (customer instanceof Customer) {
            handleCustomer(authManager, inventoryManager, orderManager, reviewRate, scanner, (Customer) customer);
        } 
        
        else {
        	System.out.println("--------------------------------------");
            System.out.println("Wrong Username or Password. Try again.");
            System.out.println("--------------------------------------");
        }
    }

    
    private static void handleAdmin(AuthManager authManager, InventoryManager inventoryManager, OrderManager orderManager, AdminDashboard adminDashboard, ReviewRate reviewRate, Scanner scanner) {
       
    	while (true) {
            System.out.println("********************************");
            System.out.println("Admin Menu:");
            System.out.println("1. View Inventory");
            System.out.println("2. View Orders");
            System.out.println("3. Manage Users");
            System.out.println("4. View Sales Report");
            System.out.println("5. View Customer Ratings & Reviews");
            System.out.println("6. Logout");
            System.out.println("********************************");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                inventoryManager.printInventory();
            } 
            
            else if (choice.equals("2")) {
                adminDashboard.handleOrders(orderManager);
            } 
            
            else if (choice.equals("3")) {
                adminDashboard.manageUsers(authManager, scanner);
            } 
            
            else if (choice.equals("4")) {
                adminDashboard.viewSalesReport(orderManager);
            } 
            
            else if (choice.equals("5")) {
                adminDashboard.viewCustomerReviews(reviewRate);
            } 
            
            else if (choice.equals("6")) {
                System.out.println("--------------------");
                System.out.println("Logging out...");
                System.out.println("--------------------");
                break;
            } 
            
            else {
            	System.out.println("---------------------------------");
                System.out.println("Invalid choice, please try again.");
                System.out.println("---------------------------------");
            }
        }
    }

    private static void handleSeller(AuthManager authManager, InventoryManager inventoryManager, Scanner scanner) {
        while (true) {
            System.out.println("Seller Menu:");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Update Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Add Stock Quantity");
            System.out.println("6. Logout");

            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                inventoryManager.printInventory();
            }

            else if (choice.equals("2")) {
            	
                System.out.println("Enter book details (id, title, author, genre, price, quantity):");
                
                int id = Integer.parseInt(scanner.nextLine());
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                String genre = scanner.nextLine();
                
                double price = Double.parseDouble(scanner.nextLine());
                int quantity = Integer.parseInt(scanner.nextLine());
                
                Book newBook = new Book(id, title, author, genre, price, quantity);
                inventoryManager.addBook(newBook);
                
                System.out.println("++++++++++");
                System.out.println("Book added.");
                System.out.println("++++++++++");
            } 
            
            else if (choice.equals("3")) {
            	
                System.out.println("Enter the ID of the book to update:");
                
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new title:");
                String title = scanner.nextLine();
                
                System.out.println("Enter new author:");
                String author = scanner.nextLine();
                
                System.out.println("Enter new genre:");
                String genre = scanner.nextLine();
                
                System.out.println("Enter new price:");
                double price = Double.parseDouble(scanner.nextLine());
                
                System.out.println("Enter new quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                
                inventoryManager.updateBook(id, title, author, genre, price, quantity);
            } 
            
            else if (choice.equals("4")) {
            	
                System.out.println("Enter the ID of the book to remove:");
                int id = Integer.parseInt(scanner.nextLine());
                inventoryManager.removeBook(id);
            } 
            
            else if (choice.equals("5")) {
                System.out.println("Enter the ID of the book to add stock quantity:");
                int id = Integer.parseInt(scanner.nextLine());
                
                System.out.println("Enter the quantity to add:");
                int quantity = Integer.parseInt(scanner.nextLine());
                
                inventoryManager.addStockQuantity(id, quantity);
            }  
            
            else if (choice.equals("6")) {
            	System.out.println("--------------------");
                System.out.println("Logging out...");
                System.out.println("--------------------");
                break;
            } 
            
            else {
                System.out.println("---------------------------------");
                System.out.println("Invalid choice, please try again.");
                System.out.println("---------------------------------");
            }
        }
    }

    
    private static void handleCustomer(AuthManager authManager, InventoryManager inventoryManager, OrderManager orderManager, ReviewRate reviewRate, Scanner scanner, Customer customer) {
        Cart cart = new Cart();
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Books");
            System.out.println("2. Search and Sort Books");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Orders");
            System.out.println("7. Leave Review");
            System.out.println("8. Logout");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                inventoryManager.printInventory();
            } 
            
            else if (choice.equals("2")) {
                SearchSort.displayMenu(inventoryManager.getBooks());
            }
            
            else if (choice.equals("3")) {
            	
                System.out.println("Enter book title to add to cart:");
                String title = scanner.nextLine();
                
                Book book = SearchSort.searchBook(inventoryManager.getBooks(), title);
                
                if (book != null) {
                    System.out.println("Enter quantity:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    
                    cart.addItem(new CartItem(book, quantity));
                    inventoryManager.decreaseStockQuantity(book.getId(), quantity);
                    
                    System.out.println("--------------------");
                    System.out.println("Book added to cart.");
                    System.out.println("--------------------");
                } 
                
                else {
                	System.out.println("--------------------");
                    System.out.println("Book not found.");
                    System.out.println("--------------------");
                }
                
            } 
            
            else if (choice.equals("4")) {
                System.out.println("Cart:\n" + cart);
            } 
            
            else if (choice.equals("5")) {
                CheckoutManager checkoutManager = new CheckoutManager();
                checkoutManager.checkout(cart, customer, orderManager);
            } 
            
            else if (choice.equals("6")) {
                System.out.println("Orders:");
                
                for (Order order : orderManager.getOrders()) {
                	
                    if (order.getCustomer().equals(customer)) {
                        System.out.println(order);
                    }
                }
            } 
            
            else if (choice.equals("7")) {
            	
                System.out.println("Enter book title to review:");
                String title = scanner.nextLine();
                
                Book book = SearchSort.searchBook(inventoryManager.getBooks(), title);
                
                if (book != null) {
                    System.out.println("Enter rating (1-5):");
                    int rating = Integer.parseInt(scanner.nextLine());
                    
                    System.out.println("Enter review:");
                    String review = scanner.nextLine();
                    
                    reviewRate.addReview(customer, book, rating, review);
                    
                    System.out.println("--------------------");
                    System.out.println("Review added.");
                    System.out.println("--------------------");
                } 
                
                else {
                	System.out.println("--------------------");
                    System.out.println("Book not found.");
                    System.out.println("--------------------");
                }
            } 
            
            else if (choice.equals("8")) {
            	System.out.println("--------------------");
                System.out.println("Logging out...");
                System.out.println("--------------------");
                break;
            } 
            
            else {
            	System.out.println("---------------------------------");
                System.out.println("Invalid choice, please try again.");
                System.out.println("---------------------------------");
            }
        }
    }
}
