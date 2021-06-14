package poly.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SQLQuery;

import poly.domain.FavoriteRep;
import poly.entity.Favorite;
import poly.util.HibernateUtil;

public class FavoriteDAO extends BaseDAO<Favorite, Integer> {

	public List<Object[]> favVideoRep() {
		String sql = "SELECT v.title, COUNT(*), MIN(f.likedDate), MAX(f.likedDate) FROM favorites f "
				+ "JOIN videos v on f.videoId = v.id GROUP BY v.title";
		SQLQuery<Object[]> query = this.session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		return list;
	}

	public List<Object[]> favUserRep(String videoId) {
		String sql = "SELECT u.username, u.fullname, u.email, f.likedDate FROM favorites f "
				+ "join users u on f.userId = u.username join videos v on f.videoId = v.id where v.id = :videoId";
		SQLQuery<Object[]> query = this.session.createSQLQuery(sql);
		query.setParameter("videoId", videoId);
		List<Object[]> list = query.list();
		return list;
	}

	public List<Object[]> favShareRep(String videoId) {
		String sql = "SELECT u.fullname, u.email, s.sharedDate FROM shares s "
				+ "join users u on s.userId = u.username JOIN videos v on s.videoId = v.id" + " where v.id = :videoId";
		SQLQuery<Object[]> query = this.session.createSQLQuery(sql);
		query.setParameter("videoId", videoId);
		List<Object[]> list = query.list();
		return list;
	}

	@Override
	public Favorite findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
