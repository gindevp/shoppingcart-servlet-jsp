package poly.controller.site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.dao.UserDAO;
import poly.entity.User;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.SessionUtil;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet("/sites/users/edit_profile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfileController() {
		super();
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtil.getLoginedUsername(request);

		User user = userDAO.findById(username);
		request.setAttribute("user", user);
		request.setAttribute("view", "/sites/users/edit_profile.jsp");
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			String username = SessionUtil.getLoginedUsername(request);
			User oldUser = userDAO.findById(username);
			user.setUsername(oldUser.getUsername());
			user.setAdmin(oldUser.getAdmin());
			user.setPassword(oldUser.getPassword());
			
			System.out.println(user.toString());

			if (userDAO.update(user)) {
				request.setAttribute("message", "Updated succesfully!");
			} else {
				request.setAttribute("error", "Update failed!");
			}
			this.doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
