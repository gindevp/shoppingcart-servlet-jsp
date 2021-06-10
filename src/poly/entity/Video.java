package poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Videos")
public class Video implements Serializable {

	@Id
	@Column(name = "VideoID")
	private String videoId;

	@Column(name = "Title")
	private String title;

	@Column(name = "Poster")
	private String poster;

	@Column(name = "Views")
	private Integer views;

	@Column(name = "Description")
	private String description;

	@Column(name = "Active")
	private Integer active;

	public Video() {
		super();
	}

	public Video(String videoId, String title, String poster, Integer views, String description, Integer active) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.active = active;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", poster=" + poster + ", views=" + views
				+ ", description=" + description + ", active=" + active + "]";
	}

}
