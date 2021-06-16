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


@WebServlet(urlPatterns = { "/admin/videos", "/admin/videos/create", "/admin/videos/edit", "/admin/videos/delete" })
@MultipartConfig
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	public VideoController() {
		super();
		videoDAO = new VideoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI().replace(request.getContextPath() + "/admin/videos", "");
		System.out.println(action);
		switch (action) {
		case "/create":
			this.create(request, response);
			break;
		case "/edit":
			this.edit(request, response);
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
		request.setAttribute("viewAdmin", "/admin/videos/videos.jsp");
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getRequestURI().replace(request.getContextPath() + "/admin/videos", "");
		System.out.println(action);
		switch (action) {
		case "/create":
			this.create(request, response);
			break;
		case "/edit":
			this.edit(request, response);
			break;
		case "/delete":
			this.delete(request, response);
			break;
		default:
			this.index(request, response);
			break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Video video = videoDAO.findById(id);
			if (videoDAO.delete(video)) {
				request.setAttribute("message", "Deleted!");
			} else {
				request.setAttribute("error", "Delete failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/videos").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			String id = request.getParameter("id");
			Video old = videoDAO.findById(id);
			BeanUtils.populate(video, request.getParameterMap());
			boolean isUpload = UploadUtil.isUpload(request, "upload");
			String fileName = UploadUtil.upload(request, "upload", "images");
			video.setPoster(isUpload ? fileName : old.getPoster());
			System.out.println(video.toString());
			if (videoDAO.update(video)) {
				request.setAttribute("message", "Update successfully!");
			} else {
				request.setAttribute("error", "Update failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/videos").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			video.setPoster(UploadUtil.upload(request, "upload", "images"));
			System.out.println(video.toString());
			if (videoDAO.create(video)) {
				request.setAttribute("message", "Created successfully!");
			} else {
				request.setAttribute("error", "Create failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/videos").forward(request, response);

	}

}
