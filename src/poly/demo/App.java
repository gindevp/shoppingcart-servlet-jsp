package poly.demo;

import java.util.Arrays;
import java.util.List;

import poly.dao.FavoriteDAO;
import poly.dao.UserDAO;
import poly.dao.VideoDAO;
import poly.domain.FavoriteRep;
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
//		Video video = new Video();
//		video.setId("ID1");
//		video.setTitle("Title1");
//		video.setPoster("Poster");
//		video.setViews(4);
//		video.setDes("des");
//		video.setActive(1);
//		dao.create(video);

		FavoriteDAO favDao = new FavoriteDAO();
		try {
			List<Object[]> list = favDao.favUserRep("video1");
			list.forEach(i -> {
				System.out.println(i[0]);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		List<Video> list = dao.getActiveVideo();
//		list.forEach(i -> System.out.println(i.toString()));
	}

}
