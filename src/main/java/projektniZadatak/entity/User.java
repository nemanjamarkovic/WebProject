package projektniZadatak.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
enum Role {VIEWER, ADMIN, MANAGER};

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String lastname;
	@Column
	private String phoneNumber;
	@Column
	private String email;
	@Column
	private Date date;
	@Column
	private Role role;
	@Column
	boolean active;
	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private Cinema cinema;
	
	
	
	
	
	
	
	

}
