package OnlineBookStoreManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String generateSalesReport() {
    	
        double totalSales = 0;
        
        Map<String, Integer> bookSales = new HashMap<>();
        Map<String, Double> revenueByBook = new HashMap<>();

        for (Order order : orders) {        	
            totalSales += order.getTotalAmount();
            
            for (CartItem item : order.getCart().getItems()) {
            	
                String bookTitle = item.getBook().getTitle();
                int quantity = item.getQuantity();
                double itemTotal = item.getTotalPrice();

                bookSales.put(bookTitle, bookSales.getOrDefault(bookTitle, 0) + quantity);
                revenueByBook.put(bookTitle, revenueByBook.getOrDefault(bookTitle, 0.0) + itemTotal);
            }
        }

        StringBuilder report = new StringBuilder();
        report.append("Total Sales: ").append(totalSales).append(" MMK\n");
        report.append("Book Sales:\n");

        for (String bookTitle : bookSales.keySet()) {
            report.append(bookTitle)
                  .append(" - ")
                  .append(bookSales.get(bookTitle))
                  .append(" units sold, Total Revenue: ")
                  .append(revenueByBook.get(bookTitle))
                  .append(" MMK\n");
        }

        return report.toString();
    }
}
