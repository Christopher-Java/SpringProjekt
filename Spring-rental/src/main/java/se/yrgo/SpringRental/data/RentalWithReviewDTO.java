package se.yrgo.SpringRental.data;

import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.domain.Review;

public class RentalWithReviewDTO {
    private Rental rental;
    private Review review;

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}