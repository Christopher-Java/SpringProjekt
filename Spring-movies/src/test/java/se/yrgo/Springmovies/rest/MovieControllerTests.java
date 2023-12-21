package se.yrgo.Springmovies.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.yrgo.Springmovies.domain.Movie;
import se.yrgo.Springmovies.service.MovieService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class MovieControllerTests {
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllMovies_WhenMoviesExist() {
        // Fixa mocken
        when(movieService.getAllmovies()).thenReturn(Arrays.asList(new Movie(), new Movie()));

        ResponseEntity<List<Movie>> response = movieController.getAllMovies();

        // Kontrollera
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void getAllMovies_WhenEmpty() {
        // Fixa mocken
        when(movieService.getAllmovies()).thenReturn(Collections.emptyList());

        ResponseEntity<List<Movie>> response = movieController.getAllMovies();

        // Kontrollera
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }

    @Test
    void createMovie_ReturnsOk_OnSuccess() {
        Movie movie = new Movie();

        ResponseEntity<String> response = movieController.createMovie(movie);

        // Kontrollera
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Successfully added movie: " + movie, response.getBody());
        verify(movieService, times(1)).createMovie(movie);
    }

    @Test
    void createMovie_ReturnsInternalServerError_OnFailure() {
        Movie movie = new Movie();
        doThrow(new RuntimeException("Simulated error")).when(movieService).createMovie(movie);

        ResponseEntity<String> response = movieController.createMovie(movie);

        // Kontrollera
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Failed to create movie", response.getBody());
        verify(movieService, times(1)).createMovie(movie);
    }
}
