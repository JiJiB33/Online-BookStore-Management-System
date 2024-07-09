package OnlineBookStoreManagementSystem;

public class Review {
    private Customer customer;
    private Book book;
    private int rating;
    private String review;

    public Review(Customer customer, Book book, int rating, String review) {
        this.customer = customer;
        this.book = book;
        this.rating = rating;
        this.review = review;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Review by " + customer.getUsername() + ":\n" +
                "Book: " + book.getTitle() + "\n" +
                "Rating: " + rating + "/5\n" +
                "Review: " + review + "\n";
    }
}
