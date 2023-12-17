package se.yrgo.SpringRental.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.service.RentalService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {


    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @GetMapping("/getAllRentals")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/findByDate/{date}")
    public List<Rental> findByDate(@PathVariable Date date) {
        return rentalService.findByDate(date);
    }

    @GetMapping("/findById")
    public Optional<Rental> findById(Long id) {
        return rentalService.findById(id);
    }

    @GetMapping("/findByCustomerId/{id}")
    public Rental findByCustomerId(@PathVariable Long id) {
        return rentalService.findByCustomerId(id);
    }


    @PostMapping("/create-rental")
    public ResponseEntity<String> createRental(@RequestBody Rental rental) {
        rentalService.createRental(rental);
        return ResponseEntity.ok("Rental created successfully" + rental);
    }


}
