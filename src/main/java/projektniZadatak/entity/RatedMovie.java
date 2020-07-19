package projektniZadatak.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RatedMovie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private String description;
    @Column
    private Date date;
    @Column
    private int duration;
    @Column
    private double rating;

    @Override
    public String toString() {
        return "RatedMovie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public RatedMovie(Long id, String title, String genre, String description, double rating, int duration, Date date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.date = date;
        this.duration = duration;

    }
    public RatedMovie(){}



}
