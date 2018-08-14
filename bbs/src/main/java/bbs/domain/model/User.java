package bbs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class User implements Serializable{
	@Id
	private String userId;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	// Constructor	
	public User() {}


	public User(String userId, String password, String firstName, String lastName, RoleName roleName) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleName = roleName;
	}

	// Getter and Setter
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public RoleName getRoleName() {
		return roleName;
	}


	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
