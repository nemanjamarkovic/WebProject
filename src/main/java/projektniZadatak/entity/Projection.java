package projektniZadatak.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Projection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	private String day;
	
	@Column
	private long price;

	@Column
	private int free;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Movie movie;
	
	@ManyToMany(mappedBy="projections")
	private List<Hall> halls=new ArrayList<Hall>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cinema cinema;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "reservations",
			joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
	private List<Viewer> viewers=new ArrayList<Viewer>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<Viewer> getViewers() {
		return viewers;
	}

	public void setViewers(List<Viewer> viewers) {
		this.viewers = viewers;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public Projection(Long id, String day, long price, int free, Movie movie, List<Hall> halls, Cinema cinema, List<Viewer> viewers) {
		this.id = id;
		this.day = day;
		this.price = price;
		this.movie = movie;
		this.halls = halls;
		this.cinema = cinema;
		this.viewers = viewers;
		this.free = free;
	}

	@Override
	public String toString() {
		return "Projection{" +
				"id=" + id +
				", day='" + day + '\'' +
				", price=" + price +
				", movie=" + movie +
				", halls=" + halls +
				", cinema=" + cinema +
				", viewers=" + viewers +
				'}';
	}
	public Projection(){

	}
}
