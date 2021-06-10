package poly.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shares")
public class Share {
	@Id
	@Column(name = "SharedId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shareId;

	@Column(name = "Username")
	private String username;

	@Column(name = "VideoId")
	private String VideoId;

	@Column(name = "Email")
	private String emails;

	@Column(name = "SharedDate")
	private Date shareDate;

	public Share() {
		super();
	}

	public Share(Integer shareId, String username, String videoId, String emails, Date shareDate) {
		super();
		this.shareId = shareId;
		this.username = username;
		VideoId = videoId;
		this.emails = emails;
		this.shareDate = shareDate;
	}

	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
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

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	@Override
	public String toString() {
		return "Share [shareId=" + shareId + ", username=" + username + ", VideoId=" + VideoId + ", emails=" + emails
				+ ", shareDate=" + shareDate + "]";
	}

}
