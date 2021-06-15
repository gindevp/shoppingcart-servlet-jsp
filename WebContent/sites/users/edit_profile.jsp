<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form class="col-6 mx-auto" action="sites/users/edit_profile" method="post">
	<div class="card">
		<div class="card-header">
			<h5 class="text-primary">Edit profile</h5>
		</div>
		<div class="card-body">
			<div class="row">
				<jsp:include page="/sites/common/inform.jsp"></jsp:include>
			</div>
			<div class="row">

				<div class="form-group col">
					<label for="">Username:</label> <input type="text" name="username"
						required id="" class="form-control" value="${user.username }" disabled>
					<small id="helpId" class="text-muted">Username is required</small>
				</div>

				<div class="form-group col">
					<label for="">Password:</label> <input type="password" required value="${user.password }" disabled
						name="password" id="" class="form-control"> <small
						id="helpId" class="text-muted">Password is required</small>
				</div>
			</div>
			<div class="row">
				<div class="form-group col">
					<label for="">Fullname:</label> <input type="text" name="fullname"
						value="${user.fullname }" id="" class="form-control" placeholder=""
						aria-describedby="helpId"> <small id="helpId"
						class="text-muted">Fullname is required</small>
				</div>

				<div class="form-group col">
					<label for="">Email Address:</label> <input type="email"
						value="${user.email }" name="email" id="" class="form-control"
						placeholder="" aria-describedby="helpId"> <small
						id="helpId" class="text-muted">Email Address is required</small>
				</div>
			</div>
		</div>
		<div class="card-footer text-right">
			<button type="submit" class="btn btn-primary">Update</button>
		</div>
	</div>
</form>