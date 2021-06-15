package poly.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "email")
	private String email;

	@Column(name = "admin")
	private Integer admin = 0;

	@OneToMany(mappedBy = "user")
	private List<Share> shares = new ArrayList<Share>();

	@OneToMany(mappedBy = "user")
	private List<Favorite> favorites = new ArrayList<Favorite>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullname=" + fullname + ", email=" + email
				+ ", admin=" + admin + "]";
	}

}
