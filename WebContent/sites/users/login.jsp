<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="fontawesome-free-5.15.3-web/css/all.css">
</head>

<body>
	<div class="container">
		<div class="row my-5">
			<form class="col-5 mx-auto" action="" method="post">
				<div class="card">
					<div class="card-header">
						<h5 class="text-primary">LOGIN</h5>
					</div>
					<div class="card-body">
						<div class="row">
							<jsp:include page="/sites/common/inform.jsp"></jsp:include>
						</div>
						<div class="form-group">
							<label for="">Username:</label> <input type="text"
								name="username" id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Username is required</small>
						</div>

						<div class="form-group">
							<label for="">Password:</label> <input type="password"
								name="password" id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Password is required</small>
						</div>

						<div class="form-check form-check-inline">
							<label for="rem"><input id="rem" type="checkbox"
								class="form-check-input" name="remember">Remember me?</label>
						</div>
					</div>
					<div class="card-footer text-right">
						<div class="row">
							<button class="col m-2 btn btn-primary">Login</button>

							<button type="button" class="btn col m-2 btn border border-primary text-primary bg-light" data-toggle="modal"
								data-target="#createModal">Registration</button>

							<!-- Modal -->
							<div class="modal fade" id="createModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<form
											action="${pageContext.request.contextPath }/regis"
											enctype="multipart/form-data" method="POST">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Add User</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<label for="">Name:</label> <input type="text" name="name"
														class="form-control">
												</div>
												<div class="form-group">
													<label for="">Poster:</label> <input type="file"
														name="upload" class="form-control-file">
												</div>
											</div>
											<div class="modal-footer">
												<input type="button" class="btn btn-secondary"
													data-dismiss="modal" value="Close"> <input
													type="submit" class="btn btn-success" value="Save">
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<a href="" class="text-primary text-3 mx-auto"><small>Forgot
								Password</small></a>
					</div>
				</div>
			</form>
		</div>
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