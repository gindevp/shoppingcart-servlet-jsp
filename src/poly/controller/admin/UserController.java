package poly.controller.admin;

import java.io.IOException;
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

@WebServlet(urlPatterns = { "/admin/users", "/admin/users/create", "/admin/users/edit", "/admin/users/delete" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO uDao;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
		this.uDao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI().replace(request.getContextPath() + "/admin/users", "");
		System.out.println("Action: " + action);
		switch (action) {
		case "/create":
			this.create(request, response);
			break;
		case "/edit":
			this.edit(request, response);
			break;
		case "/delete":
			this.delete(request, response);
			break;
		default:
			this.index(request, response);
			break;
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user.toString());
			user.setPassword(HashUtil.hash(user.getPassword()));
			if (uDao.create(user)) {
				request.setAttribute("message", "Created successfully!");
			} else {
				request.setAttribute("error", "Create failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/users").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user.toString());
			User oldUser = uDao.findById(user.getUsername());
			user.setPassword(oldUser.getPassword());
			uDao.update(user);
			if (uDao.update(user)) {
				request.setAttribute("message", "Update successfully!");
			} else {
				request.setAttribute("error", "Update failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/users").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			User user = uDao.findById(id);
			if (uDao.delete(user)) {
				request.setAttribute("message", "Deleted!");
			} else {
				request.setAttribute("error", "Delete failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/users").forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = uDao.getAll("User");
		System.out.println(users.size());
		request.setAttribute("users", users);
		request.setAttribute("viewAdmin", "/admin/users/users.jsp");
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI().replace(request.getContextPath() + "/admin/users", "");
		System.out.println("Action: " + action);
		switch (action) {
		case "/create":
			this.create(request, response);
			break;
		case "/edit":
			this.edit(request, response);
			break;
		case "/delete":
			this.delete(request, response);
			break;
		default:
			this.index(request, response);
			break;
		}
	}

}
