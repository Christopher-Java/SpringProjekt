package se.yrgo.SpringRental.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.service.RentalService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping("/rental")
public class RentalController {


    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/deleteRental/{id}")
    public void deleteRental(@PathVariable Long id ){
        Optional<Rental> rental = rentalService.findById(id);
        if (rental.isPresent()) {
            rentalService.deleteRental(id);
        } else {
            System.out.println("Could find rental with that id");
        }
    }


    @GetMapping("/getAllRentals")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/findByDate/{date}")
    public List<Rental> findByDate(@PathVariable Date date) {
        return rentalService.findByDate(date);
    }

    @GetMapping("/findById/{id}")
    public Optional<Rental> findById(@PathVariable Long id) {
        return rentalService.findById(id);
    }

    @GetMapping("/findByCustomerId/{id}")
    public List<Rental> findByCustomerId(@PathVariable Long id) {
        return rentalService.findByCustomerId(id);
    }


    @PostMapping("/create-rental")
    public ResponseEntity<Map<String,Object>> createRental(@RequestBody Rental rental) {
        rentalService.createRental(rental);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rental created successfully");
        response.put("Rental", rental);

        return ResponseEntity.ok(response);
    }


}
