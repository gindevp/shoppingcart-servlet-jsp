package poly.domain;

public class ChangePassword {
	private String username;
	private String password;
	private String newPassword;
	private String confirmPassword;

	public ChangePassword() {
		super();
	}

	public ChangePassword(String username, String password, String newPassword, String confirmPassword) {
		super();
		this.username = username;
		this.password = password;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
