package poly.dao;

import java.util.List;

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

}
