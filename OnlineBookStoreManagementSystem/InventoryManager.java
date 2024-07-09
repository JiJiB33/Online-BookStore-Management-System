package OnlineBookStoreManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryManager {
	
    private List<Book> books;

    public InventoryManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int id, String title, String author, String genre, double price, int quantity) {
    	
        for (Book book : books) {
        	
            if (book.getId() == id) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setPrice(price);
                book.setQuantity(quantity);
            	System.out.println("-------------");
                System.out.println("Book updated.");
                System.out.println("-------------");
                return;
            }
        }
        System.out.println("---------------");
        System.out.println("Book not found.");
        System.out.println("---------------");
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("-------------");
        System.out.println("Book removed.");
        System.out.println("-------------");
    }
    

    public void addStockQuantity(int id, int quantity) {
        for (Book book : books) {
        	
            if (book.getId() == id) {
                book.setQuantity(book.getQuantity() + quantity);
                System.out.println("-----------------------");
                System.out.println("Stock quantity updated.");
                System.out.println("-----------------------");
                return;
            }
        }
        System.out.println("---------------");
        System.out.println("Book not found.");
        System.out.println("---------------");
    }

    
    public void decreaseStockQuantity(int id, int quantity) {
        for (Book book : books) {
        	
            if (book.getId() == id) {
                book.setQuantity(book.getQuantity() - quantity);           
                return;
            }
        }
        System.out.println("---------------");
        System.out.println("Book not found.");
        System.out.println("---------------");
    }

    
    public List<Book> getBooks() {
        return books;
    }

    
    public Book searchBook(String title) {
        for (Book book : books) {
        	
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void printInventory() {
        System.out.println(String.format("%-4s %-30s %-20s %-15s %-10s %s", "ID", "Name", "Author Name", "Genre", "Qty", "Price (MMK)"));
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");

    }
}
