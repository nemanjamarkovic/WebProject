package projektniZadatak.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Projection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String day;
	
	@Column
	private long price;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Movie movie;
	
	@ManyToMany(mappedBy="projections")
	private List<Hall> halls=new ArrayList<Hall>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cinema cinema;
	
	@ManyToMany(mappedBy="reservedTickets")
	private List<Viewer> viewers=new ArrayList<Viewer>();
	
	
}
