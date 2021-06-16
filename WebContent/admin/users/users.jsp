<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav class="navbar navbar-light bg-secondary justify-content-between">
	<a class="navbar-brand text-light">
		<h4>User Management</h4>
	</a>
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-success" data-toggle="modal"
		data-target="#createModal"><i class="fas fa-plus-circle"></i> New User</button>

	<!-- Modal -->
	<div class="modal fade" id="createModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="admin/users/create" method="POST">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add User</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="">Username:</label> <input type="text"
								required="required" class="form-control" name="username">
						</div>
						<div class="form-group">
							<label for="">Fullname:</label> <input type="text"
								required="required" class="form-control" name="fullname">
						</div>
						<div class="form-group">
							<label for="">Password:</label> <input type="password"
								required="required" class="form-control" name="password">
						</div>
						<div class="form-group">
							<label for="">Email:</label> <input type="email"
								required="required" class="form-control" name="email">
						</div>
						<div class="form-group">
							<label for="">Role:</label> <select class="form-control"
								name="admin" id="">
								<option value="1">Admin</option>
								<option value="0">User</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-secondary"
							data-dismiss="modal" value="Close" /> <input type="submit"
							class="btn btn-success" value="Save" />
					</div>
				</form>
			</div>
		</div>
	</div>
</nav>
<jsp:include page="/sites/common/inform.jsp"></jsp:include>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Username</th>
			<th>Fullname</th>
			<th>Email</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="user" items="${users }">
			<tr>
				<td>${user.username }</td>
				<td>${user.fullname }</td>
				<td>${user.email }</td>
				<td>${user.admin == 1 ? "Admin" : "User" }</td>
				<td>
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#editModal${user.username }"><i class="fas fa-edit"></i> Edit</button> <!-- Modal -->
					<div class="modal fade" id="editModal${user.username }">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<form action="admin/users/edit?id=${user.username}"
									method="POST">

									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="">Username:</label> <input type="text"
												value=${user.username } required="required" readonly
												class="form-control" name="username">
										</div>
										<div class="form-group">
											<label for="">Fullname:</label> <input type="text"
												value=${user.fullname } required="required"
												class="form-control" name="fullname">
										</div>
										<div class="form-group">
											<label for="">Email:</label> <input type="email"
												value=${user.email } required="required"
												class="form-control" name="email">
										</div>
										<div class="form-group">
											<label for="">Role:</label> <select class="form-control"
												name="admin" id="">
												<option ${user.admin == 1 ? "selected" : ""} value="1">Admin</option>
												<option ${user.admin == 0 ? "selected" : ""} value="0">User</option>
											</select>
										</div>
									</div>
									<div class="modal-footer">
										<input type="button" class="btn btn-secondary"
											data-dismiss="modal" value="Close" /> <input type="submit"
											class="btn btn-info" value="Update" />
									</div>
								</form>
							</div>
						</div>
					</div>

					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#deleteModal${user.username }"><i class="fas fa-trash-alt"></i> Delete</button> <!-- Modal -->
					<div class="modal fade" id="deleteModal${user.username }"
						tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<form action="admin/users/delete?id=${user.username}"
									method="POST">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Delete
											User</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">Are you sure delete user has
										username: ${user.username}</div>
									<div class="modal-footer">
										<input type="button" class="btn btn-secondary"
											data-dismiss="modal" value="Close" /> <input type="submit"
											class="btn btn-danger" value="Confirm" />
									</div>
								</form>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</c:forEach>

	</tbody>
</table>