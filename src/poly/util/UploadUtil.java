package poly.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtil {
	public static String upload(HttpServletRequest request, String parameter, String folder) throws Exception {
		Part part = request.getPart(parameter);
		if (!part.getSubmittedFileName().contains(".")) {
			return "";
		} else {
			String fileName = "img" + String.valueOf(getRd()) + part.getSubmittedFileName();
			String path = request.getServletContext().getRealPath("/" + folder);
			if (!Files.exists(Path.of(path))) {
				Files.createDirectory(Path.of(path));
			}
			part.write(path + "/" + fileName);
			return fileName;
		}
	}

	public static int getRd() {
		return 10000000 + new Random().nextInt(89999900);
	}

	public static boolean isUpload(HttpServletRequest request, String parameter) throws IOException, ServletException {
		return request.getPart(parameter).getSubmittedFileName().contains(".");
	}
}
