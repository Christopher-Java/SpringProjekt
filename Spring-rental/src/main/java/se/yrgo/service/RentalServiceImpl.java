package se.yrgo.service;

import se.yrgo.data.Rentalrepository;
import se.yrgo.domain.Rental;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class RentalServiceImpl implements RentalService {

    private Rentalrepository rentalRepository;

    @Override
    public void createRental(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }


    @Override
    public List<Rental> findByDate(Date date) {
        return rentalRepository.findByDate(date);
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return rentalRepository.findById(id);
    }

    @Override
    public Rental findByCustomerId(Long customerId) {
        return rentalRepository.findCustomerById(customerId);
    }

}
