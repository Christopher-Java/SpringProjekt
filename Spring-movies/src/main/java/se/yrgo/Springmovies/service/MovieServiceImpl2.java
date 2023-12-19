package se.yrgo.Springmovies.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.Springmovies.domain.Genre;
import se.yrgo.Springmovies.domain.Movie;
import se.yrgo.Springmovies.domain.MovieSeries;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class MovieServiceImpl2 implements MovieService{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Movie> getAllmovies() {
        return entityManager.createQuery("SELECT m FROM Movie m",Movie.class).getResultList();
    }

    @Override
    public List<MovieSeries> getAllMovieSeries(){
        return entityManager.createQuery("SELECT m.movieSeries FROM Movie m", MovieSeries.class).getResultList();
    }

    @Override
    public void createMovieSeries(MovieSeries movieSeries) {
        entityManager.persist(movieSeries);
    }

    @Override
    public void createMovie(Movie movie) {
        entityManager.persist(movie);
    }



    @Override
    public Optional<Movie> getMovie(Long movieId) {
        return Optional.ofNullable(entityManager.createQuery("SELECT m FROM Movie m INNER JOIN MovieSeries ms ON ms.id=m.id WHERE m.id= :movieId", Movie.class).setParameter("movieId", movieId).getSingleResult());
    }

    @Override
    public List<Movie> getMoviesByGenre(Genre.MovieGenre genre) {
        return entityManager.createQuery("SELECT m FROM Movie m WHERE m.genre= :movieGenre", Movie.class).setParameter("movieGenre",genre).getResultList();
    }
}
