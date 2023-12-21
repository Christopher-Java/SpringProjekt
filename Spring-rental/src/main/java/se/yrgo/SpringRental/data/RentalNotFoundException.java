package se.yrgo.SpringRental.data;

public class RentalNotFoundException extends Exception {
    public RentalNotFoundException(String message) {
        super(message);
    }
}
