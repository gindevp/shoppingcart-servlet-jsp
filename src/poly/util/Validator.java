package poly.util;

import java.util.List;

public class Validator {
	public static String isEmpty(String[] title, String...arg) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arg.length; i++) {	
			if (arg[i].trim().isEmpty()) {
				sb.append("+ ").append(title[i]).append("<br>");
			}
		}
		return sb.toString();
	}
	
	public static boolean isExists(String value, List<String> data) {
		int flag = 0;
		for (String item : data) {
			if (item.equalsIgnoreCase(value.trim())) {
				flag++;
			}
		}
		return flag != 0;
	}
}
