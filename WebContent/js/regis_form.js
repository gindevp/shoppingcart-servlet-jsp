function validation() {
	var username = document.form.username.value;
	var password = document.form.password.value;
	if (username.length.trim == 0) {
		alert("Username not allow empty!");
		return false;
	} else if (password.length.trim < 4 || password.length.trim > 8) {
		alert("Passwod nhu cac");
		return false;
	}
	
	return true;
}