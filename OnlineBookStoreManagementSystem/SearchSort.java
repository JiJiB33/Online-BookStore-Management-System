package OnlineBookStoreManagementSystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SearchSort {
	
    public static void sortBooksByName(List<Book> books) {
        Collections.sort(books);
    }

    public static void sortBooksByPrice(List<Book> books) {
        books.sort(Comparator.comparingDouble(Book::getPrice));
    }

    public static void sortBooksByGenre(List<Book> books) {
        books.sort(Comparator.comparing(Book::getGenre));
    }

    public static Book searchBook(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    
    public static void displayMenu(List<Book> books) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Search Book");
            System.out.println("2. Sort by Price");
            System.out.println("3. Sort by Name");
            System.out.println("4. Sort by Genre");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
            	
                System.out.println("Enter book title to search:");
                String title = scanner.nextLine();
                
                Book book = searchBook(books, title);
                
                if (book != null) {
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                    System.out.println("Found Book: " + book);
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                } 
                
                else {
                	System.out.println("---------------");
                    System.out.println("Book not found.");
                	System.out.println("---------------");

                }               
                
            } 
            
            else if (choice.equals("2")) {
            	
                sortBooksByPrice(books);
                
                System.out.println("Books sorted by price:");
                System.out.println("----------------------------------------------------------------------------------------------------");
                books.forEach(System.out::println);
                System.out.println("----------------------------------------------------------------------------------------------------");

            } 
            
            else if (choice.equals("3")) {
            	
                sortBooksByName(books);
                
                System.out.println("Books sorted by name:");
                System.out.println("----------------------------------------------------------------------------------------------------");
                books.forEach(System.out::println);
                System.out.println("----------------------------------------------------------------------------------------------------");

            } 
            
            else if (choice.equals("4")) {
            	
                sortBooksByGenre(books);
                
                System.out.println("Books sorted by genre:");
                System.out.println("----------------------------------------------------------------------------------------------------");
                books.forEach(System.out::println);
                System.out.println("----------------------------------------------------------------------------------------------------");

            } 
            
            else if (choice.equals("5")) {
            	System.out.println("---------------");
                System.out.println("Exiting...");
            	System.out.println("---------------");

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
