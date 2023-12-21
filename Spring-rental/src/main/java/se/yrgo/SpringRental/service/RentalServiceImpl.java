package se.yrgo.SpringRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.SpringRental.data.RentalNotFoundException;
import se.yrgo.SpringRental.data.Rentalrepository;
import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.domain.Review;


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
    public List<Rental> getAllRentals() throws RentalNotFoundException {
        try {
            return rentalRepository.findAll();
        } catch (Exception e) {
            throw new RentalNotFoundException("Couldnt find all rentals" + e);
        }

    }


    @Override
    public List<Rental> findByDate(Date date) throws RentalNotFoundException {
        try {
            return rentalRepository.findByDate(date);
        } catch (Exception e) {
            throw new RentalNotFoundException("Couldnt find a rental by this date : " + date + " \n \n" + e);
        }
    }

    @Override
    public Optional<Rental> findById(Long id) throws RentalNotFoundException {
        try {
            return rentalRepository.findById(id);
        } catch (Exception e) {
            throw new RentalNotFoundException("Couldnt find rental with this id : " + id + "\n \n " + e);
        }
    }

    @Override
    public List<Rental> findByCustomerId(Long customerId) throws RentalNotFoundException {
        try {
            return rentalRepository.findCustomerById(customerId);
        } catch (Exception e) {
            throw new RentalNotFoundException("Couldnt find rental by this customerId : " + customerId + "\n \n" + e);
        }
    }

    @Override
    public void deleteRental(Long id) throws RentalNotFoundException {
        try {
            Optional<Rental> rental = rentalRepository.findById(id);
            rental.ifPresent(rentalRepository::delete);
        } catch (Exception e) {
            throw new RentalNotFoundException("Couldnt delete rental with this id : " + id + "\n \n" + e);
        }
    }

    @Override
    public void createRentalWithReview(Rental rental, Review review) {
        rental.setReview(review);
        rentalRepository.save(rental);
    }

}
