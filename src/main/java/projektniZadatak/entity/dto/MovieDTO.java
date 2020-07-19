package projektniZadatak.entity.dto;

import javax.persistence.Column;
import java.util.Date;

public class MovieDTO {

    private String title;
    private String description;
    private String genre;
    private int duration;
    private Date date;
    private double rating;
    private Long id;

    public MovieDTO(String title, String description, String genre, int duration, Date date, double rating, Long id) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
        this.date = date;
        this.rating = rating;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDTO(String title, String description, String genre, int duration, Date date, Long id) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
        this.date = date;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public MovieDTO(String title, String description, String genre, int duration, Date date, double rating) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
        this.date = date;
        this.rating = rating;
    }
}
