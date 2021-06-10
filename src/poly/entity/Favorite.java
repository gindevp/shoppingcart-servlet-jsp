package poly.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Favorites")
public class Favorite implements Serializable {
	@Id
	@Column(name = "FavoriteId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer favoriteId;

	@Column(name = "Username")
	private String username;

	@Column(name = "VideoId")
	private String VideoId;

	@Column(name = "LikedDate")
	private Date likedDate;

	public Favorite() {
		super();
	}

	public Favorite(Integer favoriteId, String username, String videoId, Date likedDate) {
		super();
		this.favoriteId = favoriteId;
		this.username = username;
		VideoId = videoId;
		this.likedDate = likedDate;
	}

	public Integer getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVideoId() {
		return VideoId;
	}

	public void setVideoId(String videoId) {
		VideoId = videoId;
	}

	public Date getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}

	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", username=" + username + ", VideoId=" + VideoId + ", likedDate="
				+ likedDate + "]";
	}
}
