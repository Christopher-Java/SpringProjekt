package se.yrgo.Springmovies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.Springmovies.data.MoviesRepository;
import se.yrgo.Springmovies.domain.Genre;
import se.yrgo.Springmovies.domain.Movie;

import java.util.List;
import java.util.Optional;

// USE PORT 8081
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MoviesRepository moviesRepository;


    @Override
    public List<Movie> getAllmovies() {
        return moviesRepository.findAll();
    }

    @Override
    public void createMovie(Movie movie) {
        moviesRepository.save(movie);
    }

    @Override
    public List<Movie> getMoviesByGenre(Genre.MovieGenre genre){
        return moviesRepository.findMovieByGenre(genre);
    }

    @Override
    public Optional<Movie> getMovie(Long id) {
        return moviesRepository.findById(id);
    }
}
