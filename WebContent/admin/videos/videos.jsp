<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<nav class="navbar navbar-light bg-secondary justify-content-between">
	<a class="navbar-brand text-light">
		<h4>Video Management</h4>
	</a>
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-success" data-toggle="modal"
		data-target="#createModal">
		<i class="fas fa-plus-circle"></i> New Video
	</button>

	<!-- Modal -->
	<div class="modal fade" id="createModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form action="admin/videos/create" method="POST"
					enctype="multipart/form-data">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add User</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="">Video ID:</label> <input type="text"
								required="required" class="form-control" name="id">
						</div>
						<div class="form-group">
							<label for="">Title:</label> <input type="text"
								required="required" class="form-control" name="title">
						</div>
						<div class="form-group">
							<label for="">Poster:</label> <input type="file"
								class="form-control-file" name="upload">
						</div>
						<div class="form-group">
							<label for="">View:</label> <input type="number"
								required="required" class="form-control" name="views">
						</div>
						<div class="form-group">
							<label for="">Description:</label>
							<textarea name="des" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<label for="">Status:</label> <select class="form-control"
								name="active" id="">
								<option value="1">Active</option>
								<option value="0">Inactive</option>
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
<table class="table table-border table-striped">
	<thead>
		<tr>
			<th>Video ID</th>
			<th>Title</th>
			<th>Poster</th>
			<th>View Count</th>
			<th>Description</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="video" items="${videos }">
			<tr>
				<td>${video.id }</td>
				<td>${video.title }</td>
				<td><img
					src="${pageContext.request.contextPath }/images/${video.poster}"
					alt="Empty" width="120rem"></td>
				<td>${video.views}</td>
				<td>${video.des}</td>
				<td>${video.active == 1 ? 'Active' : 'Inactive'}</td>
				<td>
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#editModal${video.id }">
						<i class="fas fa-edit"></i> Edit
					</button> <!-- Modal -->
					<div class="modal fade" id="editModal${video.id }">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<form action="admin/videos/edit?id=${video.id}" method="POST"
									enctype="multipart/form-data">

									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Edit Video</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="">Video ID:</label> <input type="text"
												value="${video.id}" required="required" class="form-control"
												name="id">
										</div>
										<div class="form-group">
											<label for="">Title:</label> <input type="text"
												required="required" value="${video.title}"
												class="form-control" name="title">
										</div>
										<div class="form-group">
											<label for="">Poster:</label> <input type="file"
												class="form-control-file" name="upload">
										</div>
										<div class="form-group">
											<label for="">View:</label> <input type="number"
												required="required" value="${video.views}"
												class="form-control" name="views">
										</div>
										<div class="form-group">
											<label for="">Description:</label>
											<textarea name="des" class="form-control">${video.des}</textarea>
										</div>
										<div class="form-group">
											<label for="">Status:</label> <select class="form-control"
												name="active" id="">
												<option ${video.active==1 ? "selected" : "" } value="1">Active
												</option>
												<option ${video.active==0 ? "selected" : "" } value="0">Inactive
												</option>
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
						data-target="#deleteModal${video.id }">
						<i class="fas fa-trash-alt"></i> Delete
					</button> <!-- Modal -->
					<div class="modal fade" id="deleteModal${video.id }" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<form action="admin/videos/delete?id=${video.id }" method="POST">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Delete
											Video</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">Are you sure delete user has id:
										${video.id }</div>
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