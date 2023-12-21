package se.yrgo.Springmovies.domain;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Movie")
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NonNull
    private String movieTitle;
    private Date releaseDate;
    private String description;

    @NonNull
    private Genre.MovieGenre genre;

    @ManyToOne(cascade = CascadeType.MERGE)
    private MovieSeries movieSeries;

    public Movie(Long id, String movieTitle, Date releaseDate, String description, Genre.MovieGenre genre, MovieSeries movieSeries) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.description = description;
        this.genre = genre;
        this.movieSeries = movieSeries;
    }

    public MovieSeries getMovieSeries() {
        return movieSeries;
    }

    public void setMovieSeries(MovieSeries movieSeries) {
        this.movieSeries = movieSeries;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Movie() {

    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre.MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(Genre.MovieGenre genre) {
        this.genre = genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
