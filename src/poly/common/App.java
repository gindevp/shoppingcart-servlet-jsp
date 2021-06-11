package poly.common;

import poly.dao.UserDAO;
import poly.entity.User;
import poly.util.HashUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		User user = dao.findById("123");
		System.out.println(HashUtil.verify("123", user.getPassword()));
	}

}
