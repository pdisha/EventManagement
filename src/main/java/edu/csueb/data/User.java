package edu.csueb.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author disha
 */
@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column
	private String username;
	@Column
	private String fName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String phNumber;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", username=" + username + ", fName=" + fName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phNumber=" + phNumber + "]";
	}
	
	
}
