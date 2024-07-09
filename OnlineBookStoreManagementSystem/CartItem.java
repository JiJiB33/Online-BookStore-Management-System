package OnlineBookStoreManagementSystem;

public class CartItem {
    private Book book;
    private int quantity;

    public CartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return book.getPrice() * quantity;
    }

    @Override
    public String toString() {
    	return book.getTitle() + " - " + quantity + " @ " + book.getPrice() + " MMK each" + "\n" + "---------------------------------------------";
    }
}