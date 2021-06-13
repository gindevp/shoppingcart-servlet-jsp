package poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.dao.VideoDAO;
import poly.entity.User;
import poly.entity.Video;
import poly.util.PageInfo;
import poly.util.PageType;
import poly.util.UploadUtil;

/**
 * Servlet implementation class VideoController
 */
@WebServlet(urlPatterns = { "/admin/videos", "/admin/videos/create", "/admin/videos/store", "/admin/videos/edit",
		"/admin/videos/update", "/admin/videos/delete", "/admin/videos/index" })
@MultipartConfig
public class AdVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
	private int isEdit = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdVideoController() {
		super();
		videoDAO = new VideoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI().replace(request.getContextPath() + "/admin/videos", "");
		System.out.println("_Action: " + action);
		switch (action) {
		case "/create":
			this.create(request, response);
			break;
		case "/edit":
			this.edit(request, response);
			break;
		case "/update":
			this.update(request, response);
			break;
		case "/delete":
			this.delete(request, response);
			break;
		default:
			this.index(request, response);
			break;
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> videos = videoDAO.getAll("Video");
		request.setAttribute("videos", videos);

		request.setAttribute("isLogin", 1);
		request.setAttribute("isEdit", 0);

		request.setAttribute("video", new Video());
		PageInfo.PrepareAndForward(request, response, PageType.AD_VIDEO_PAGE);
	}

	private void fillTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> videos = videoDAO.getAll("Video");
		request.setAttribute("videos", videos);
		request.setAttribute("isLogin", 1);
		PageInfo.PrepareAndForward(request, response, PageType.AD_VIDEO_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Video video = videoDAO.findById(id);
		if (videoDAO.delete(video)) {
			request.setAttribute("message", "Deleted!");
		} else {
			request.setAttribute("error", "Delete failed!");
		}
		PageInfo.PrepareAndForward(request, response, PageType.AD_VIDEO_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			String id = request.getParameter("id");
			Video video2 = videoDAO.findById(id);
			System.out.println("Before: " + video.toString());
			System.out.println("Old: " + video2.toString());
			video.setId(id);
			video.setPoster(UploadUtil.upload(request, "cover", "images", video.getId()));

			System.out.println(video.toString());

			if (videoDAO.update(video)) {
				request.setAttribute("message", "Updated succesfully");
			} else {
				request.setAttribute("error", "Update failed!");
			}
			request.setAttribute("video", video);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.fillTable(request, response);
		PageInfo.PrepareAndForward(request, response, PageType.AD_VIDEO_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.isEdit = 1;
		request.setAttribute("isEdit", isEdit);
		String id = request.getParameter("id");
		System.out.println("ID: " + id);
		Video video = videoDAO.findById(id);
		System.out.println(video.toString());
		request.setAttribute("video", video);
		PageInfo.PrepareAndForward(request, response, PageType.AD_VIDEO_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			if (video.getPoster() != null) {
				video.setPoster(UploadUtil.upload(request, "cover", "images", video.getId()));
			}

			if (videoDAO.create(video)) {
				request.setAttribute("message", "Video Inserted!");
			} else {
				request.setAttribute("video", video);
				request.setAttribute("error", "Insert failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.fillTable(request, response);
		PageInfo.PrepareAndForward(request, response, PageType.AD_VIDEO_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void updateStatus(HttpServletRequest request) {
		request.setAttribute("enableCreate", this.isEdit != 1);

		request.setAttribute("enableUpdate", this.isEdit == 1);

		request.setAttribute("enableDelete", this.isEdit == 1);

	}

}
