<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">

<head>
<title>Admin</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/Asm_Sof301/">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="./fontawesome-free-5.15.3-web/css/all.css">
<style>
html {
	min-height: 100vh;
}

body {
	height: 100%;
}

table {
	width: 70rem !important;
}
</style>
</head>

<body>
	<div class="container border">
		<nav
			class="navbar row sticky-top navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Administration</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#menu" aria-controls="menu" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="menu">
				<div class="navbar-nav">
					<li class="nav-item"><a href="admin/videos" class="nav-link">Videos</a></li>
					<li class="nav-item"><a href="admin/users" class="nav-link">Users</a></li>
					<li class="nav-item"><a href="admin/reports" class="nav-link">Reports</a></li>
				</div>
			</div>
			<div class="navbar-nav ml-auto">
				<h5 class="nav-link text-dark">Hello ${username }</h5>
				<a class="nav-link" href="logoff">Sign out</a>
			</div>
		</nav>
		<main class="row">
			<jsp:include page="${viewAdmin }"></jsp:include>
		</main>
		<footer class="row footer bg-light p-2">
			<div class="col text-center">FPT Polytechnic &copy;2021. All
				rights reserved.</div>
		</footer>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>
