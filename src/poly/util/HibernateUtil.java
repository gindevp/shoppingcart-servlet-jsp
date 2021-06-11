package poly.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static Session session;

	public static SessionFactory getSessionFactory() {
		if (factory == null || !factory.isOpen()) {
			Configuration cfg = new Configuration();
			factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}

	public static Session getSession() {
		if (session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		return session;
	}
}
