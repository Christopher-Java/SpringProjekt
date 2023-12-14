package se.yrgo.Springmovies.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.yrgo.Springmovies.domain.Movie;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT m FROM Movie m WHERE m.genre = :genre")
    public List<Movie> findMovieByGenre(@Param("genre") String movieGenre);
}
