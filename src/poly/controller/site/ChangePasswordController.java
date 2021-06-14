package poly.controller.site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.dao.UserDAO;
import poly.domain.ChangePassword;
import poly.entity.User;
import poly.util.HashUtil;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.SessionUtil;


@WebServlet("/sites/change_password")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	
    public ChangePasswordController() {
        super();
        this.userDao = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChangePassword newUser = new ChangePassword();
		String usernameLogin = SessionUtil.getLoginedUsername(request);
		User userLogin = userDao.findById(usernameLogin);
		try {
			BeanUtils.populate(newUser, request.getParameterMap());
			if (HashUtil.verify(newUser.getPassword(), userLogin.getPassword())) {
				if (newUser.getNewPassword().equalsIgnoreCase(newUser.getConfirmPassword())) {
					userLogin.setPassword(HashUtil.hash(newUser.getNewPassword()));
					if (userDao.update(userLogin)) {
						request.setAttribute("message", "Password has changed!");
					}
					
				} else {
					request.setAttribute("error", "New Password and New Confirm Password are not identical!");
				}
			} else {
				request.setAttribute("error", "Invalid Username or Password");
			}
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
