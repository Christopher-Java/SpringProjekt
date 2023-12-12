package se.yrgo.Springmovies.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.Springmovies.domain.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {
}
