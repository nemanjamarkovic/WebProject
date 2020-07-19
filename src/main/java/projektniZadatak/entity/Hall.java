package projektniZadatak.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Hall implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int capacity;
	@Column
	private String label;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cinema cinema;
	
	@ManyToMany
	@JoinTable(name = "TimeProjection",
    joinColumns = @JoinColumn(name = "hall_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
	private Set<Projection> projections = new HashSet<>();

	public Hall(int id, int capacity, String label, Cinema cinema, Set<Projection> projections) {
		this.id = id;
		this.capacity = capacity;
		this.label = label;
		this.cinema = cinema;
		this.projections = projections;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Set<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Hall(){
	}
}
