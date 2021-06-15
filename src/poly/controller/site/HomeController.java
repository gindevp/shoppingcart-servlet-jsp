package poly.controller.site;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.dao.FavoriteDAO;
import poly.dao.ShareDAO;
import poly.dao.UserDAO;
import poly.dao.VideoDAO;
import poly.domain.Email;
import poly.entity.Share;
import poly.entity.User;
import poly.entity.Video;
import poly.util.HashUtil;
import poly.util.MailUtil;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.SessionUtil;

@WebServlet(urlPatterns = { "/sites/home", "/sites/home/share", "/sites/home/like" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO vDao;
	private UserDAO uDao;
	private ShareDAO sDao;
	private FavoriteDAO fDao;


	public HomeController() {
		super();
		vDao = new VideoDAO();
		uDao = new UserDAO();
		sDao = new ShareDAO();
		fDao = new FavoriteDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI().replace(request.getContextPath() + "/sites/home", "");
		System.out.println("Action: " + action);
		switch (action) {
		case "/share":
			this.share(request, response);
			break;
		case "/like":
			this.like(request, response);
			break;
		default:
			this.index(request, response);
			break;
		}
	}

	private void like(HttpServletRequest request, HttpServletResponse response) {
		String videoId = request.getParameter("videoId");
		System.out.println(videoId);
	}

	private void share(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String fEmail = request.getParameter("email");
		String videoId = request.getParameter("videoId");
		if (videoId != null && fEmail != null) {
			Email email = new Email();
			email.setToEmail(fEmail);
			email.setSubject("Shared Favorite Video");
			StringBuilder sb = new StringBuilder();
			sb.append("<b>Dear: Mr/Mrs</b> ").append("<br>");
			sb.append("The video is more interesting and i want to share with you!").append("<br>");
			sb.append("Click here to see video: ").append("").append("<br>");

			sb.append("Regard! ").append("<br>");
			sb.append("Administration ").append("<br>");

			email.setContent(sb.toString());
			try {
				MailUtil.send(email);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Share share = new Share();

			String username = SessionUtil.getLoginedUsername(request);
			User user = uDao.findById(username);
			Video video = vDao.findById(videoId);

			share.setEmails(fEmail);
			share.setSharedDate(new Date(new java.util.Date().getTime()));
			share.setVideo(video);
			share.setUser(user);

			sDao.create(share);
			request.setAttribute("message", "Video link has sent!");

		} else {
			request.setAttribute("error", "Invalid email!");
		}
		this.index(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> videos = vDao.getAll("Video");
		request.setAttribute("videos", videos);

		request.setAttribute("view", "/sites/home/home.jsp");
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
