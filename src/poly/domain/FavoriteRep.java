package poly.domain;

import java.sql.Date;

public class FavoriteRep {
	private String title;
	private Long count;
	private Date newest;
	private Date oldest;

	public FavoriteRep() {
		super();
	}

	public FavoriteRep(String title, Long count, Date newest, Date oldest) {
		super();
		this.title = title;
		this.count = count;
		this.newest = newest;
		this.oldest = oldest;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
