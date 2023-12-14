package se.yrgo.SpringRental.service;

import se.yrgo.SpringRental.domain.Rental;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RentalService {

    public void createRental(Rental rental);

    List<Rental> getAllRentals();


    List<Rental> findByDate(Date date);

    public Optional<Rental> findById(Long id);

    public Rental findByCustomerId(Long customerId);


}
