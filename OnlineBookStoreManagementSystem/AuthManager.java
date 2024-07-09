package OnlineBookStoreManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class AuthManager {
	
    private Map<String, User> users;
    private Map<String, Integer> attempts;
    private Map<String, Long> lockTime;

    public AuthManager() {
        users = new HashMap<>();
        attempts = new HashMap<>();
        lockTime = new HashMap<>();
        
        //admin
        users.put("admin", new Admin("admin", "admin123"));
        attempts.put("admin", 0);
        lockTime.put("admin", 0L);

        //seller
        users.put("seller", new Seller("seller", "seller123"));

        //customers
        users.put("john", new Customer("john", "john123"));
        users.put("niki", new Customer("niki", "niki123"));
    }

    public User authenticate(String username, String password) {
    	//timer method called
        long currentTime = System.currentTimeMillis();
        
        if (username.equals("admin") && lockTime.get("admin") > currentTime) {
        	System.out.println("------------------------------------------------------------");
            System.out.println("Your account has been locked for 5 mins!! Come back later :3");
        	System.out.println("------------------------------------------------------------");

            return null;
        }

        User user = users.get(username);
        
        if (user != null && user.getPassword().equals(password)) {
            if (username.equals("admin")) {
                attempts.put("admin", 0); //attempts
            }
            return user;
        }

        if (username.equals("admin")) {
        	
            int currentAttempts = attempts.get("admin");
            currentAttempts++;
            attempts.put("admin", currentAttempts);

            if (currentAttempts >= 3) {
            	
                lockTime.put("admin", currentTime + 5 * 60 * 1000); //lock for 5 minutes
            	System.out.println("------------------------------------------------------------");
                System.out.println("Your account has been locked for 5 mins!! Come back later :3");
            	System.out.println("------------------------------------------------------------");
                
                return null;
            } 
            
            else {
                System.out.println("Invalid username or password. You have " + (3 - currentAttempts) + " attempt(s) left.");
            	System.out.println("------------------------------------------------------------");

            }
        } 
        
        else {
        	System.out.println("--------------------------------------");
            System.out.println("Wrong Username or Password. Try again.");
            System.out.println("--------------------------------------");
        }

        return null;
    }
    

    public Map<String, User> getUsers() {
        return users;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void removeUser(String username) {
        users.remove(username);
    }
}
