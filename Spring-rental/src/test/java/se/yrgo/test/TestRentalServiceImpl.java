package se.yrgo.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.yrgo.SpringRental.data.RentalNotFoundException;
import se.yrgo.SpringRental.domain.Rental;
import se.yrgo.SpringRental.rest.RentalController;
import se.yrgo.SpringRental.service.RentalService;
import se.yrgo.SpringRental.service.RentalServiceImpl;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import se.yrgo.SpringRental.data.Rentalrepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RentalServiceTest {

    @Mock
    private Rentalrepository rentalrepository;

    @InjectMocks
    private RentalServiceImpl rentalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllRentals() throws RentalNotFoundException {
        Rental rental1 = new Rental();
        Rental rental2 = new Rental();

        when(rentalrepository.findAll()).thenReturn(Arrays.asList(rental1, rental2));

        List<Rental> rentals = rentalService.getAllRentals();

        assertEquals(2, rentals.size());
    }

    @Test
    void testCreateRental() {
        Rental rental = new Rental();
        rental.setCustomerId(1L);
        rental.setMovieId(2L);
        rental.setRentalCost(75);
        rental.setRentalDate(Date.valueOf("2023-12-12"));

        rentalService.createRental(rental);

        verify(rentalrepository).save(rental);
    }

    @Test
    void testGetAllRentalsRentalNotFoundException() {
        when(rentalrepository.findAll()).thenThrow(new RuntimeException("Exception in test was thrown"));

        assertThrows(RentalNotFoundException.class, () -> rentalService.getAllRentals());
    }

}


