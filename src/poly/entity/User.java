package poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	@Id
	@Column(name = "Username")	
	private String username;
	
	@Column(name = "Fullname")
	private String fullname;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "Admin")
	private Integer admin;

	public User() {
		super();
	}

	public User(String username, String fullname, String email, Integer admin) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", fullname=" + fullname + ", email=" + email + ", admin=" + admin + "]";
	}

}
