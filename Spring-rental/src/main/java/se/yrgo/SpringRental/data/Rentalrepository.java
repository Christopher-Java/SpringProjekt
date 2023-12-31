package se.yrgo.SpringRental.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.yrgo.SpringRental.domain.Rental;

import java.sql.Date;
import java.util.List;

@Repository
public interface Rentalrepository extends JpaRepository<Rental, Long> {
    @Query(value = "SELECT r FROM Rental as r WHERE r.rentalDate = :date")
    List<Rental> findByDate(Date date);

    @Query(value = "SELECT r FROM Rental as r WHERE r.customerId = :customerId")
    List<Rental> findCustomerById(Long customerId);

}
