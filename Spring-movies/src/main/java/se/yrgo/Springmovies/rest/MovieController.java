package se.yrgo.Springmovies.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.Springmovies.domain.Genre;
import se.yrgo.Springmovies.domain.Movie;
import se.yrgo.Springmovies.domain.MovieSeries;
import se.yrgo.Springmovies.service.MovieService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Qualifier("movieServiceImpl2")
    @Autowired
    private MovieService movieService;

    /* Get-all funktionerna undersöker först om det som ska returneras är tomt, isåfall returneras en NOT_FOUND statuskod
     *  Om inget undantag uppkommer returneras den efterfrågade listan med en OK-statuskod
     *
     * GetMovie kollar helt enkelt om den hittar något, annars returneras NOT_FOUND
     *
     * Create-funktionerna fångar eventuella undantag och returnerar isåfall ett INTERNAL_SERVER_ERROR
     * */

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            List<Movie> movies = movieService.getAllmovies();
            if (movies.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
            }
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            System.err.println("Error getting all movies" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get-all-movie-series")
    public ResponseEntity<List<MovieSeries>> getAllMovieSeries() {
        try {
            List<MovieSeries> movieSeriesList = movieService.getAllMovieSeries();

            if (movieSeriesList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
            }

            return ResponseEntity.ok(movieSeriesList);
        } catch (Exception e) {
            System.err.println("Error getting all movie series" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("get-movie-by-id/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable long id) {
        Optional<Movie> movie = movieService.getMovie(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("get-movies-by-genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable Genre.MovieGenre genre) {
        try {
            List<Movie> movies = movieService.getMoviesByGenre(genre);
            if (movies.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
            }
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            System.err.println("Error getting movies by genre" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("get-genres")
    public ResponseEntity<List<Genre.MovieGenre>> getAllMovieGenres() {
        try {
            List<Genre.MovieGenre> genres = List.of(Genre.MovieGenre.values());

            if (genres.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
            }

            return ResponseEntity.ok(genres);
        } catch (Exception e) {
            System.err.println("Error getting all movie genres: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/create-movie")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie) {
        try {
            movieService.createMovie(movie);
            return ResponseEntity.ok("Successfully added movie: " + movie);
        } catch (Exception e) {
            System.err.println("Error creating movie: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create movie");
        }
    }

    @PostMapping("/create-movie-series")
    public ResponseEntity<String> createMovieSeries(@RequestBody MovieSeries movieSeries) {
        try {
            movieService.createMovieSeries(movieSeries);
            return ResponseEntity.ok("MovieSeries created successfully!");
        } catch (Exception e) {
            System.err.println("Error creating movie series: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create movie series");
        }
    }


}
