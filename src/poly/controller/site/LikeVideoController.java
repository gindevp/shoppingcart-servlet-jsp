package poly.controller.site;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.dao.FavoriteDAO;
import poly.dao.ShareDAO;
import poly.dao.UserDAO;
import poly.dao.VideoDAO;
import poly.util.PageInfo;
import poly.util.PageType;

/**
 * Servlet implementation class LikeVideoController
 */
@WebServlet("/sites/like_video")
public class LikeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO vDao;
	private UserDAO uDao;
	private ShareDAO sDao;
	private FavoriteDAO fDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LikeVideoController() {
		super();
		vDao = new VideoDAO();
		uDao = new UserDAO();
		sDao = new ShareDAO();
		fDao = new FavoriteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("videoId");
		System.out.println("Video ID: " + id);
		if (id == null) {
			request.getRequestDispatcher("/sites/home").forward(request, response);
		} else {
			request.setAttribute("videoId", id);
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
		}
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
