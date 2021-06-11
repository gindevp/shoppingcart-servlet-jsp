package poly.controller.site;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;

import poly.dao.UserDAO;
import poly.domain.LoginForm;
import poly.entity.User;
import poly.util.CookieUtil;
import poly.util.HashUtil;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.SessionUtil;

/**
 * Servlet implementation class SiteLoginController
 */
@WebServlet("/login")
public class SiteLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteLoginController() {
        super();
        userDAO = new UserDAO();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtil.get("username", request);
		if (username == null) {
			PageInfo.PrepareAndForward(request, response, PageType.SITE_LOGIN_PAGE, false);
			return;
		}
		SessionUtil.add(request, "username", username);
		PageInfo.PrepareAndForward(request, response, PageType.SITE_HOME_PAGE, false);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginForm form = new LoginForm();
		try {
			BeanUtils.populate(form, request.getParameterMap());
			User user = userDAO.findById(form.getUsername());
			
			if (user != null && HashUtil.verify(form.getPassword(), user.getPassword())) {
				SessionUtil.add(request, "username", user.getId());
				if (form.isRem()) {
					CookieUtil.add("username", user.getId(), 24, response);
				} else {
					CookieUtil.add("username", user.getId(), 0, response);
				}
				System.out.println("Login success");
				response.sendRedirect(request.getContextPath() + "/sites/home");
			} else {
				request.setAttribute("user", user);
				request.setAttribute("error", "Invalid Username or Password");
				PageInfo.PrepareAndForward(request, response, PageType.SITE_LOGIN_PAGE, false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
