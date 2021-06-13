package poly.controller.site;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.dao.UserDAO;
import poly.entity.User;
import poly.util.HashUtil;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.Validator;

@WebServlet("/regis")
public class RegisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private String passSend;

	public RegisController() {
		super();
		this.userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.PrepareAndForwardSite(request, response, PageType.SITE_REGIS_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {

			BeanUtils.populate(user, request.getParameterMap());
			passSend = user.getPassword();
			user.setPassword(HashUtil.hash(user.getPassword()));
			if (userDAO.create(user)) {
				request.setAttribute("message", "Registration success!");
				PageInfo.PrepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
			} else {
				request.setAttribute("error", validate(user));
				request.setAttribute("user", user);
				PageInfo.PrepareAndForwardSite(request, response, PageType.SITE_REGIS_PAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String validate(User user) {
		String error = new String();
		String empty = Validator.isEmpty(new String[] { "Username", "Password", "Fullname", "Email" }, user.getUsername(),
				user.getPassword(), user.getFullname(), user.getEmail());

		List<User> users = userDAO.getAll("User");
		List<String> ids = new ArrayList<String>();
		List<String> emails = new ArrayList<String>();
		users.forEach(item -> {
			ids.add(item.getUsername());
			emails.add(item.getEmail());
		});

		System.out.println("User: " + user.getUsername() + " - " + user.getEmail());
		ids.forEach(i -> System.out.println(i));
		emails.forEach(i -> System.out.println(i));

		if (!empty.isEmpty()) {
			error = "Not allow empty!";
		} else if (Validator.isExists(user.getUsername(), ids)) {
			error = "Duplicate Username!";
		} else if (Validator.isExists(user.getEmail(), emails)) {
			error = "Duplicate Email!";
		}
		System.out.println(error);
		return error;
	}

}
