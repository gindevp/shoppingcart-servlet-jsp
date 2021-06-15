package poly.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import poly.dao.FavoriteDAO;
import poly.dao.UserDAO;
import poly.dao.VideoDAO;
import poly.domain.Email;
import poly.domain.FavoriteRep;
import poly.entity.Favorite;
import poly.entity.User;
import poly.entity.Video;
import poly.util.HashUtil;
import poly.util.MailUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO udao = new UserDAO();
//		User user = dao.findById("user1");
//		user.setPassword(HashUtil.hash("123"));
//		dao.update(user);

		VideoDAO vdao = new VideoDAO();
//		Video video = new Video();
//		video.setId("ID1");
//		video.setTitle("Title1");
//		video.setPoster("Poster");
//		video.setViews(4);
//		video.setDes("des");
//		video.setActive(1);
//		dao.create(video);

		FavoriteDAO favDao = new FavoriteDAO();
//		try {
//			List<Favorite> list = favDao.getAll("Favorite");
//			list.forEach(i -> {
//				System.out.println(i);
//			});
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		User user = udao.findById("user1");
		List<Favorite> favorites = user.getFavorites();
		favorites.forEach(i -> System.out.println(i));
		
//		List<Video> list = vdao.getActiveVideo();
//		list.forEach(i -> System.out.println(i.toString()));
		
//		Email email = new Email("hungnnph09719@fpt.edu.vn", "Content <br> fsd", "Subject");
//		try {
//			MailUtil.send(email);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(new Random().nextInt(900000) + 100000);
	}

}
