package poly.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
	public static Map<PageType, PageInfo> router = new HashMap();

	static {
		router.put(PageType.AD_USER_PAGE, new PageInfo("User Management", "/views/admin/users/users.jsp", null));
		router.put(PageType.AD_REPORT_PAGE, new PageInfo("Report", "/views/admin/reports/reports.jsp", null));
		router.put(PageType.AD_VIDEO_PAGE, new PageInfo("Video Management", "/views/admin/videos/videos.jsp", null));
		router.put(PageType.SITE_HOME_PAGE, new PageInfo("Home", "/views/sites/home/home.jsp", null));
		router.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login", "/views/sites/users/login.jsp", null));
		router.put(PageType.SITE_REGIS_PAGE, new PageInfo("Registrtion", "/views/sites/users/regis.jsp", null));
		router.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password", "/views/sites/users/change-password.jsp", null));
		router.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile", "/views/sites/users/edit-profile.jsp", null));
		router.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password", "/views/sites/users/forgot-password.jsp", null));
		router.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite", "/views/sites/videos/favorite.jsp", null));
		router.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video Detail", "/views/sites/videos/detail.jsp", null));
		router.put(PageType.SITE_SHARE_PAGE, new PageInfo("Share", "/views/sites/videos/share.jsp", null));

	}
	

	public static void PrepareAndForward(HttpServletRequest request, HttpServletResponse response, PageType type, boolean role)
			throws ServletException, IOException {
		PageInfo page = router.get(type);
		request.setAttribute("page", page);
		if (role) {
			request.getRequestDispatcher("/views/admin/layout.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/sites/layout.jsp").forward(request, response);
		}
	}

	private String title;
	private String contentUrl;
	private String scriptUrl;

	public PageInfo() {
		// TODO Auto-generated constructor stub
	}

	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}

	public static Map<PageType, PageInfo> getRouter() {
		return router;
	}

	public static void setRouter(Map<PageType, PageInfo> router) {
		PageInfo.router = router;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getScriptUrl() {
		return scriptUrl;
	}

	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}

}
