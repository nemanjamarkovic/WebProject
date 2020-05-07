package projektniZadatak.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
	private int duration;
	@Column
	private float rating;


	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Projection> projections=new ArrayList<Projection>();
	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<WatchedMovie> watchedMovies=new ArrayList<WatchedMovie>();
	
	
	
	
	
	
	
	

}
