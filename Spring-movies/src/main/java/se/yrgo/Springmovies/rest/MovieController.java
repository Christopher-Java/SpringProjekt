package se.yrgo.Springmovies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.Springmovies.domain.Movie;
import se.yrgo.Springmovies.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/get-all-movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllmovies();
    }

    @GetMapping("get-movie-by-id")
    public Optional<Movie> getMovieById(@RequestBody long id){
        return movieService.getMovie(id);
    }

    @GetMapping("get-movies-by-genre")
    public List<Movie> getMoviesByGenre(@RequestBody String genre){
        return movieService.getMoviesByGenre(genre);
    }

    @PostMapping("/create-movie")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie){
        movieService.createMovie(movie);
        return ResponseEntity.ok("Successfully added movie: " + movie);
    }

}
