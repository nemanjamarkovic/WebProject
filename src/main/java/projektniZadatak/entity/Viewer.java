package projektniZadatak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Viewer extends User implements Serializable {
	
	@OneToMany(mappedBy = "viewer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<WatchedMovie> watchedMovies = new ArrayList<WatchedMovie>();
	
	
	@ManyToMany(mappedBy = "viewers")
	private List<Projection> reservedTickets=new ArrayList<Projection>();


	public Viewer(String name, String lastname, String email, String password) {
		super(name, lastname, email, password);
	}
	public Viewer(){
	}
	@JsonIgnore
	public List<WatchedMovie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(List<WatchedMovie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}
	@JsonIgnore
	public List<Projection> getReservedTickets() {
		return reservedTickets;
	}

	public void setReservedTickets(List<Projection> reservedTickets) {
		this.reservedTickets = reservedTickets;
	}

	public Viewer(String name, String lastname, String email, String password, List<WatchedMovie> watchedMovies, List<Projection> reservedTickets) {
		super(name, lastname, email, password);
		this.watchedMovies = watchedMovies;
		this.reservedTickets = reservedTickets;
	}

	public Viewer(List<WatchedMovie> watchedMovies, List<Projection> reservedTickets) {
		this.watchedMovies = watchedMovies;
		this.reservedTickets = reservedTickets;
	}

	public Viewer(String name, String lastname, String email, String password, Role role) {
		super(name, lastname, email, password, role);
	}


}
