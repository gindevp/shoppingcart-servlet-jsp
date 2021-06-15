package poly.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "videoId")
	private Video video;

	@Column(name = "likedDate")
	private Timestamp likedDate = new Timestamp(new java.util.Date().getTime());

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Timestamp getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Timestamp likedDate) {
		this.likedDate = likedDate;
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user=" + user.getFullname() + ", video=" + video.getTitle() + ", likedDate=" + likedDate + "]";
	}

}
