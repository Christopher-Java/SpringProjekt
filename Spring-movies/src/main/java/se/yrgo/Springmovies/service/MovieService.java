package se.yrgo.Springmovies.service;

import se.yrgo.Springmovies.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllmovies();
    void createMovie(Movie movie);
    Optional<Movie> getMovie(Long id);
    List<Movie> getMoviesByGenre(String genre);

}
