package poly.demo;

import poly.dao.UserDAO;
import poly.dao.VideoDAO;
import poly.entity.User;
import poly.entity.Video;
import poly.util.HashUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		UserDAO dao = new UserDAO();
//		User user = dao.findById("user1");
//		user.setPassword(HashUtil.hash("123"));
//		dao.update(user);
		
		VideoDAO dao = new VideoDAO();
		Video video = new Video();
		video.setId("ID1");
		video.setTitle("Title1");
		video.setPoster("Poster");
		video.setViews(4);
		video.setDes("des");
		video.setActive(1);
		dao.create(video);
	}

}
