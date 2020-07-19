package projektniZadatak.entity.dto;

public class ProjectionDTO {

    private Long id;
    private String movieTitle;
    private String day;
    private long price;
    private int free;


    public ProjectionDTO(String movieTitle, String day, long price, int free, Long id) {
        this.movieTitle = movieTitle;
        this.day = day;
        this.price = price;
        this.free = free;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectionDTO{" +
                "movieTitle='" + movieTitle + '\'' +
                ", day='" + day + '\'' +
                ", price=" + price +
                ", free=" + free +
                '}';
    }
}


