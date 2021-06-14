package poly.domain;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.util.PageInfo;
import poly.util.PageType;

public class Email {
	private String toEmail, content, subject;

	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(String toEmail, String content, String subject) {
		super();
		this.toEmail = toEmail;
		this.content = content;
		this.subject = subject;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
