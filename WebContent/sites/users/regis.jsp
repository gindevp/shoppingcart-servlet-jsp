<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form class="col-6 mx-auto" onsubmit="return validation()" name="form"
	action="${pageContext.request.contextPath }/regis" method="post">
	<div class="card">
		<div class="card-header">
			<h5 class="text-primary">Registration</h5>
		</div>
		<div class="card-body">
			<div class="row">
				<jsp:include page="/sites/common/inform.jsp"></jsp:include>
			</div>
			<div class="row">

				<div class="form-group col">
					<label for="">Username:</label> <input type="text" name="id"
						required id="" class="form-control" value="${user.id }"> <small
						id="helpId" class="text-muted">Username is required</small>
				</div>

				<div class="form-group col">
					<label for="">Password:</label> <input type="password" required
						name="password" id="" class="form-control"> <small
						id="helpId" class="text-muted">Password is required</small>
				</div>
			</div>

			<div class="row">
				<div class="form-group col">
					<label for="">Fullname:</label> <input type="text" name="fullname"
						required id="" class="form-control" value="${user.fullname }">
					<small id="helpId" class="text-muted">Fullname is required</small>
				</div>

				<div class="form-group col">
					<label for="">Email Address:</label> <input type="email" required
						name="email" id="" class="form-control" value="${user.email }">
					<small id="helpId" class="text-muted">Email Address is
						required</small>
				</div>
			</div>
		</div>
		<div class="card-footer text-right">
			<button class="btn btn-primary">
				<i class="fas fa-sign-in-alt"></i> Sign Up
			</button>
		</div>
	</div>
</form>
