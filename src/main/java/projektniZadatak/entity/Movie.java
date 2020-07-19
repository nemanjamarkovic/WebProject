package projektniZadatak.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Movie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String genre;
	@Column
	private Date date;


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	/*public float getRating() {
		return rating;
	}*/

	/*public void setRating(float rating) {
		this.rating = rating;
	}*/

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public List<WatchedMovie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(List<WatchedMovie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}

	public Movie(Long id, String title, String description, String genre, int duration, float rating,Date date,List<Projection> projections, List<WatchedMovie> watchedMovies) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		//this.rating = rating;
		this.projections = projections;
		this.watchedMovies = watchedMovies;
		this.date = date;
	}

	@Column
	private int duration;
	//@Column
	//private float rating;


	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Projection> projections=new ArrayList<Projection>();
	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<WatchedMovie> watchedMovies=new ArrayList<WatchedMovie>();
	
	
	public Movie(){

	}
	
	
	
	
	

}
