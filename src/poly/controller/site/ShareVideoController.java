package poly.controller.site;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * Servlet implementation class ShareVideoController
 */
@WebServlet("/sites/share_video")
public class ShareVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO vDao;
	private UserDAO uDao;
	private ShareDAO sDao;

	public ShareVideoController() {
		super();
		vDao = new VideoDAO();
		uDao = new UserDAO();
		sDao = new ShareDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String id = request.getParameter("videoId");
//		System.out.println("Video ID: " + id);
//		if (id == null) {
//			response.sendRedirect(request.getContextPath() + "/home");
//		} else {
//			request.setAttribute("videoId", id);
//			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
//		}
		
		String videoId = request.getParameter("videoId");
		
		if(videoId == null) {
			response.sendRedirect(request.getContextPath() + "/sites/home");
			return;
		}
		request.setAttribute(videoId, videoId);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fEmail = request.getParameter("email");
			String videoId = request.getParameter("videoId");
			if (videoId != null) {
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
				MailUtil.send(email);
				request.setAttribute("message", "Video link has sent!");

				Share share = new Share();
				share.setEmails(fEmail);
				share.setSharedDate(new Date(new java.util.Date().getTime()));
				
				String username = SessionUtil.getLoginedUsername(request);
				User user = uDao.findById(username);
				Video video = vDao.findById(videoId);
				
				share.setVideo(video);
				share.setUser(user);
				
				sDao.create(share);
				
			} else {
				request.setAttribute("error", "Invalid email!");
			}
		} catch (Exception e) {
			request.setAttribute("error", "Invalid email!");
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SHARE_PAGE);

	}

}
