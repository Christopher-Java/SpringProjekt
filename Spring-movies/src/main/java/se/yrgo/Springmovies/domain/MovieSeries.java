package se.yrgo.Springmovies.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="MovieSeries")
public class MovieSeries {
    @Id
    private Long id;
    @NonNull
    private String movieSeries;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieSeries")
    private Set<Movie> movies;

    public String getMovieSeries() {
        return movieSeries;
    }

    public void setMovieSeries(String movieSeries) {
        this.movieSeries = movieSeries;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
