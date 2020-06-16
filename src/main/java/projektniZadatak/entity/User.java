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
	private String name;
	@Column
	private String lastname;
	@Column
	private String email;

	@Column
	private String password;

	/*@Column
	private String phoneNumber;
	@Column
	private String username;
	@Column
	private Date date;
	@Column
	private Role role;
	@Column
	boolean active;*/
	@ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private Cinema cinema;
	public User(String name, String lastname, String email,String password){
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public User(){
		this.name = "a";
		this.lastname = "a";
		this.email = "a";
	}

	public String getEmail(){return email;}
	public String getPassword(){return password;}
	public Long getId(){return id;}

	@Override
	public String toString() {
		return super.toString();
	}
}
