package projektniZadatak.entity.dto;

import javax.persistence.Column;

public class MovieDTO {

    private String title;
    private String description;
    private String genre;
    private int duration;

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

    public MovieDTO(String title, String description, String genre, int duration) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
    }
}
