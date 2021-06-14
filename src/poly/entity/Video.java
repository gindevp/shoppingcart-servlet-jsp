package poly.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video implements Serializable {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "poster")
	private String poster;

	@Column(name = "views")
	private Integer views;

	@Column(name = "des")
	private String des;

	@Column(name = "active")
	private Integer active;

	@OneToMany(mappedBy = "video")
	private List<Share> shares = new ArrayList<Share>();

	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites = new ArrayList<Favorite>();

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", poster=" + poster + ", views=" + views + ", des=" + des
				+ ", active=" + active + ", favorites=" + favorites + "]";
	}

}
