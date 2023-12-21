package se.yrgo.SpringRental.service;

import se.yrgo.SpringRental.data.RentalNotFoundException;
import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.domain.Review;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RentalService {

    public void createRental(Rental rental);

    List<Rental> getAllRentals() throws RentalNotFoundException;


    List<Rental> findByDate(Date date) throws RentalNotFoundException;

    public Optional<Rental> findById(Long id) throws RentalNotFoundException;

    public List<Rental> findByCustomerId(Long customerId) throws RentalNotFoundException;

    public void deleteRental(Long id) throws RentalNotFoundException;

    public void createRentalWithReview(Rental rental, Review review);



}
