package poly.dao;

import java.util.List;

import org.hibernate.Session;

import poly.util.HibernateUtil;

public abstract class BaseDAO<E, K> {
	protected Session session = HibernateUtil.getSession();

	public boolean create(E entity) {
		try {
			session.clear();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(E entity) {
		try {
			session.clear();
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(E entity) {
		try {
			session.clear();
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	public List<E> getAll(String name) {
		return session.createQuery("from " + name).list();
	}

	public abstract E findById(K id);
}
