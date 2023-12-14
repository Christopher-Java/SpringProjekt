package se.yrgo.Springmovies.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.Springmovies.domain.Genre;
import se.yrgo.Springmovies.domain.Movie;
import se.yrgo.Springmovies.service.MovieService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", maxAge = 3600)
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
    public List<Movie> getMoviesByGenre(@RequestBody Genre.MovieGenre genre){
        return movieService.getMoviesByGenre(genre);
    }


    @GetMapping("get-genres")
    public List<Genre.MovieGenre> getAllMovieGenres(){
        return List.of(Genre.MovieGenre.values());
    }

    @PostMapping("/create-movie")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie){
        movieService.createMovie(movie);
        return ResponseEntity.ok("Successfully added movie: " + movie);
    }

}
