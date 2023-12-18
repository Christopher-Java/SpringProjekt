package se.yrgo.Springmovies.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String movieTitle;
    private Date releaseDate;
    private String description;
    private Genre.MovieGenre genre;

    public Movie(String movieTitle, Date releaseDate, String description, Genre.MovieGenre movieGenre) {
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.description = description;
        this.genre = movieGenre;


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
