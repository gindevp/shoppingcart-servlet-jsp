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
@WebServlet("/edit_profile")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtil.getLoginedUsername(request);
		if (username == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		try {
			User user = userDAO.findById(username);
			request.setAttribute("user", user);
			PageInfo.PrepareAndForwardSite(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			String username = SessionUtil.getLoginedUsername(request);
			User oldUser = userDAO.findById(username);
			user.setAdmin(oldUser.getAdmin());

			if (userDAO.update(user)) {
				request.setAttribute("message", "Updated succesfully!");
				PageInfo.PrepareAndForwardSite(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
			} else {
				request.setAttribute("error", "Update failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
