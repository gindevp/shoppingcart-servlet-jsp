package poly.domain;

public class LoginForm {
	private String username;
	private String password;
	private boolean rem;

	public LoginForm() {
		// TODO Auto-generated constructor stub
	}

	public LoginForm(String username, String password, boolean rem) {
		super();
		this.username = username;
		this.password = password;
		this.rem = rem;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRem() {
		return rem;
	}

	public void setRem(boolean rem) {
		this.rem = rem;
	}

}
