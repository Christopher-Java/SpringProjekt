package se.yrgo.SpringRental.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SpringRental.data.RentalNotFoundException;
import se.yrgo.SpringRental.data.RentalWithReviewDTO;
import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.domain.Review;
import se.yrgo.SpringRental.service.RentalService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rental")
public class RentalController {


    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/deleteRental/{id}")
    public void deleteRental(@PathVariable Long id) throws RentalNotFoundException {
        Optional<Rental> rental = rentalService.findById(id);
        if (rental.isPresent()) {
            rentalService.deleteRental(id);
        } else {
            System.out.println("Could find rental with that id");
        }
    }


    @GetMapping("/getAllRentals")
    public List<Rental> getAllRentals() throws RentalNotFoundException {
        return rentalService.getAllRentals();
    }

    @GetMapping("/findByDate/{date}")
    public List<Rental> findByDate(@PathVariable Date date) throws RentalNotFoundException {
        return rentalService.findByDate(date);
    }

    @GetMapping("/findById/{id}")
    public Optional<Rental> findById(@PathVariable Long id) throws RentalNotFoundException {
        return rentalService.findById(id);
    }

    @GetMapping("/findByCustomerId/{id}")
    public List<Rental> findByCustomerId(@PathVariable Long id) throws RentalNotFoundException {
        return rentalService.findByCustomerId(id);
    }


    @PostMapping("/create-rental")
    public ResponseEntity<Map<String, Object>> createRental(@RequestBody Rental rental) {
        rentalService.createRental(rental);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rental created successfully");
        response.put("Rental", rental);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/createRentalWithReview")
    public ResponseEntity<Map<String, Object>> createRentalWithReview(@RequestBody RentalWithReviewDTO rentalWithReviewDTO) {
        Rental rental = rentalWithReviewDTO.getRental();
        Review review = rentalWithReviewDTO.getReview();

        rentalService.createRentalWithReview(rental, review);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Rental created successfully with review");
        response.put("Rental", rental);
        response.put("Review", review);//Kommentera ut denna rad sedan för att se hur utskriften blir

        return ResponseEntity.ok(response);
    }
}

