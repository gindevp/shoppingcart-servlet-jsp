package poly.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import poly.entity.User;

public class UserDAO extends BaseDAO<User, String> {

	@Override
	public boolean create(User entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return super.delete(entity);
	}

	@Override
	public List<User> getAll(String name) {
		// TODO Auto-generated method stub
		return super.getAll(name);
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return this.session.get(User.class, id);
	}
	
	public User findByIdAndEmail(String username, String email) {
		String query = "select u from User u where u.username = :username and u.email = :email";
		TypedQuery<User> typedQuery = this.session.createQuery(query, User.class);
		typedQuery.setParameter("username", username);
		typedQuery.setParameter("email", email);		
		User user = typedQuery.getSingleResult();
		return user;
	}

}
