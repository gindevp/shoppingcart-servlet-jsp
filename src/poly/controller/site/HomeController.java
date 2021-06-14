package poly.controller.site;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.dao.VideoDAO;
import poly.entity.Video;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.SessionUtil;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {
		"/sites/home",
		"/sites/home/share",
		"/sites/home/like"
})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO vDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		vDao = new VideoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> videos = vDao.getAll("Video");
		request.setAttribute("videos", videos);
		
		request.setAttribute("view", "/sites/home/home.jsp");
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
		
		String action = request.getRequestURI().replace(request.getContextPath() + "/sites/home", "");
		System.out.println("Action: " + action);
		switch (action) {
		case "/like":
			this.like(request, response);
			break;
		case "/share":
			this.share(request, response);
			break;
		default:
			this.index(request, response);
			break;
		}
	}

	private void like(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void share(HttpServletRequest request, HttpServletResponse response) {
		String mail = request.getParameter("mail");
		String videoId = request.getParameter("videoId");
		System.out.println(mail + " - " + videoId);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
