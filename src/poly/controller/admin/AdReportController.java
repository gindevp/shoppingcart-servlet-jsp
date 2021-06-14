package poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.dao.FavoriteDAO;
import poly.dao.VideoDAO;
import poly.entity.Video;
import poly.util.PageInfo;
import poly.util.PageType;

/**
 * Servlet implementation class ReportController
 */
@WebServlet(urlPatterns = { "/admin/reports", "/admin/reports/index", "/admin/reports/favuser", "/admin/reports/favshare"
})
public class AdReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO fDao;
	private VideoDAO vDao;

	public AdReportController() {
		super();
		fDao = new FavoriteDAO();
		vDao = new VideoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.fillVideoList(request, response);

		String action = request.getRequestURI().replace(request.getContextPath() + "/admin/reports", "");
		System.out.println(action);

		switch (action) {
		case "/favuser":
			this.setSelectedTab(request, response, 2);
			this.show(request, response);
			break;
		case "/index":
			this.setSelectedTab(request, response, 1);
			this.show(request, response);
			break;
		case "/favshare":
			this.setSelectedTab(request, response, 3);
			this.show(request, response);
			break;
		default:
			this.setSelectedTab(request, response, 1);
			this.show(request, response);
			break;
		}
		request.setAttribute("view", "/admin/reports/reports.jsp");
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}

	private void showTab2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoUserId = request.getParameter("videoUserId");
		System.out.println(videoUserId);
		List<Video> videos = vDao.getAll("Video");
		if (videoUserId == null && videos.size() > 0) {
			videoUserId = videos.get(0).getId();
		}
		List<Object[]> favUser = fDao.favUserRep(videoUserId);

		request.setAttribute("videoSelected", videoUserId);
		request.setAttribute("favUser", favUser);
	}

	private void fillVideoList(HttpServletRequest request, HttpServletResponse response) {
		List<Video> videos = vDao.getAll("Video");
		request.setAttribute("videos", videos);
	}

	private void showTab1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Object[]> favVideos = fDao.favVideoRep();
		request.setAttribute("favVideos", favVideos);

	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> favVideos = fDao.favVideoRep();
		request.setAttribute("favVideos", favVideos);

		String videoUserId = request.getParameter("videoUserId");
		String videoUserId1 = request.getParameter("videoUserId1");

		System.out.println(videoUserId);
		List<Video> videos = vDao.getAll("Video");
		if (videoUserId == null && videos.size() > 0) {
			videoUserId = videos.get(0).getId();
		}
		
		if (videoUserId1 == null && videos.size() > 0) {
			videoUserId1 = videos.get(0).getId();
		}
		
		List<Object[]> favUser = fDao.favUserRep(videoUserId);
		request.setAttribute("videoSelected", videoUserId);
		request.setAttribute("favUser", favUser);

		List<Object[]> favShare = fDao.favShareRep(videoUserId1);
		request.setAttribute("videoSelected11", videoUserId1);
		request.setAttribute("favShare", favShare);

	}

	private void setSelectedTab(HttpServletRequest request, HttpServletResponse response, int tab) {
		request.setAttribute("isSelectTab1", tab == 1 ? true : false);
		request.setAttribute("isSelectTab2", tab == 2 ? true : false);
		request.setAttribute("isSelectTab3", tab == 3 ? true : false);
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
