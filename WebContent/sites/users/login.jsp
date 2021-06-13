<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form class="col-6 mx-auto" action="${pageContext.request.contextPath }/login" method="post">
	<div class="card">
		<div class="card-header">
			<h5 class="text-primary">LOGIN</h5>
		</div>
		<div class="card-body">
			<div class="row">
				<jsp:include page="/sites/common/inform.jsp"></jsp:include>
			</div>
			<div class="form-group">
				<label for="">Username:</label> <input type="text" name="username"
					id="" class="form-control" placeholder="" aria-describedby="helpId"
					value="${user.username }"> <small id="helpId" class="text-muted">Username
					is required</small>
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
			<button class="w-100 btn btn-primary">LOGIN</button>
			<a href="${pageContext.request.contextPath }/regis" class="nav-link mx-auto p-2 text-center">Create a new
				Account</a>
		</div>
	</div>
</form>