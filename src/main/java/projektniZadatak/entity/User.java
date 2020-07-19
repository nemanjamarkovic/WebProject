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

@Entity
public class User implements Serializable {

	public enum Role {VIEWER, ADMIN, MANAGER};
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

	@Column
	private String phoneNumber;
	@Column
	private String username;
	@Column
	private Date date;
	@Column
	private Role role;
	@Column
	boolean active;
	@ManyToOne(cascade =CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Cinema cinema;
	public User(String name, String lastname, String email,String password){
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public User(String name, String lastname, String email,String password, Role role){
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(){
		this.name = "a";
		this.lastname = "a";
		this.email = "a";
	}

	public String getEmail(){return email;}
	public String getPassword(){return password;}
	public Long getId(){return id;}
	public String getName(){return name;}
	public String getLastname(){return lastname;}


	@Override
	public String toString() {
		return super.toString();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
}
