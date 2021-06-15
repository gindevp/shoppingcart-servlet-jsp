<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form class="col-6 mx-auto" action="" method="post">
	<div class="card">
		<div class="card-header">
			<h5 class="text-primary">Change Password</h5>
		</div>
		<div class="card-body">
			<div class="row">
				<jsp:include page="/sites/common/inform.jsp"></jsp:include>
			</div>
			<div class="row">
				<div class="form-group col">
					<label for="">Username:</label> <input type="text" name="username"
						value="${user.username }" id="" class="form-control" placeholder="" disabled
						aria-describedby="helpId"> <small id="helpId"
						class="text-muted">Username is required</small>
				</div>

				<div class="form-group col">
					<label for="">Password:</label> <input type="password"
						name="password" id="" class="form-control" placeholder=""
						aria-describedby="helpId"> <small id="helpId"
						class="text-muted">Password is required</small>
				</div>



			</div>

			<div class="row">
				<div class="form-group col">
					<label for="">New Password:</label> <input type="password"
						name="newPassword" id="" class="form-control" placeholder=""
						aria-describedby="helpId"> <small id="helpId"
						class="text-muted">New Password is required</small>
				</div>

				<div class="form-group col">
					<label for="">Confirm New Password:</label> <input type="password"
						name="confirmPassword" id="" class="form-control" placeholder=""
						aria-describedby="helpId"> <small id="helpId"
						class="text-muted">Confirm New Password is required</small>
				</div>
			</div>
		</div>
		<div class="card-footer text-right">
			<button class="btn btn-primary">Change Password</button>
		</div>
	</div>
</form>