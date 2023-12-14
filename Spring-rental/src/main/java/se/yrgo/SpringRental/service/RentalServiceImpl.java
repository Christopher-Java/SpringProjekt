package se.yrgo.SpringRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.SpringRental.data.Rentalrepository;
import se.yrgo.SpringRental.domain.Rental;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
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
