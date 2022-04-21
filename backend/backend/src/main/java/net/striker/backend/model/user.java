package net.striker.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
private long id;
	@Column(name="user_name")
private String username;
	@Column(name="email_Id")
private String emailId;
	@Column(name="pass_word")
private String password;

public user() {
	
}//default constructor bez of proxys which r used by hibernate


public user(String username, String emailId, String password) {
	super();
	this.username = username;
	this.emailId = emailId;
	this.password = password;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
