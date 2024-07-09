package OnlineBookStoreManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ReviewRate {
    private List<Review> reviews;

    public ReviewRate() {
        reviews = new ArrayList<>();
    }

    public void addReview(Customer customer, Book book, int rating, String reviewText) {
        Review review = new Review(customer, book, rating, reviewText);
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
