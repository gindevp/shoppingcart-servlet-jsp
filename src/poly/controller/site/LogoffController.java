package poly.controller.site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.util.CookieUtil;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.SessionUtil;

@WebServlet("/logoff")
public class LogoffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoffController() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieUtil.add("username", null, 0, resp);
		SessionUtil.invalidate(req);
		req.setAttribute("isLogin", false);
		PageInfo.PrepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE);
	}

}
