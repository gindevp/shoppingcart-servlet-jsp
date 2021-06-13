package poly.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtil {
	public static String upload(HttpServletRequest request, String parameter, String folder, String videoId)
			throws Exception {
		Part part = request.getPart(parameter);
		String fileName = videoId + "_" + part.getSubmittedFileName();
		String path = request.getServletContext().getRealPath("/" + folder);
		if (!Files.exists(Path.of(path))) {
			Files.createDirectory(Path.of(path));
		}
		part.write(path + "/" + fileName);

		return fileName;
	}
}
