package projektniZadatak.entity;

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
	
	
	@ManyToMany
	@JoinTable(name = "reservations",
    joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
	private List<Projection> reservedTickets=new ArrayList<Projection>();
	
	 
	
	
	
}
