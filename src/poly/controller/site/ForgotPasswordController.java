package poly.controller.site;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.dao.UserDAO;
import poly.domain.Email;
import poly.entity.User;
import poly.util.HashUtil;
import poly.util.MailUtil;
import poly.util.PageInfo;
import poly.util.PageType;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet("/fotgot_password")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO uDao;

	public ForgotPasswordController() {
		super();
		this.uDao = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fUsername = request.getParameter("username");
			String fEmail = request.getParameter("email");
			User fUser = uDao.findByIdAndEmail(fUsername, fEmail);
			if (fUser != null) {
				int newPassword = this.getNewPass();
				fUser.setPassword(HashUtil.hash(newPassword + ""));
				uDao.update(fUser);
				Email email = new Email();
				email.setToEmail(fEmail);
				email.setSubject("Forgot Password");
				StringBuilder sb = new StringBuilder();
				sb.append("<b>Dear:</b> ").append("<b>" + fUser.getFullname() + "</b>").append("<br>");
				sb.append("You are used the forgot password function!").append("<br>");
				sb.append("We have reset new password for you!").append("<br>");
				sb.append("Your new password is: ").append(newPassword).append("<br>");
				sb.append("Regard! ").append("<br>");
				sb.append("Administration ").append("<br>");

				email.setContent(sb.toString());
				MailUtil.send(email);
				request.setAttribute("message", "We sent password to your email!");

			} else {
				request.setAttribute("error", "Invalid username or email!");
			}
		} catch (Exception e) {
			request.setAttribute("error", "Invalid username or email!");
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);

	}

	private int getNewPass() {
		return new Random().nextInt(900000) + 100000;
	}

}
