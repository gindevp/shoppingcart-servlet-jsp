<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item"><a class="nav-link active" id="vd-tab"
		data-toggle="tab" href="#vd" role="tab" aria-controls="vd"
		aria-selected="true">Video Editing</a></li>
	<li class="nav-item"><a class="nav-link" id="vdlist-tab"
		data-toggle="tab" href="#vdlist" role="tab" aria-controls="vdlist"
		aria-selected="false">Video List</a></li>

</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="vd" role="tabpanel"
		aria-labelledby="vd-tab">
		<form action="" method="post" enctype="multipart/form-data">
			<div class="col-12">
				<jsp:include page="/admin/common/inform.jsp"></jsp:include>
			</div>
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-5">
							<img required
								src="/Asm_Sof301/images/${video.poster != null ? video.poster : 'default.jpg' }"
								width="100%" class="img-fluid p-3 border">
							<div class="form-group mt-3">
								<label for="exampleFormControlFile1">Change Poster</label> <input
									type="file" class="form-control-file" name="cover"
									id="exampleFormControlFile1">
							</div>
						</div>
						<div class="col-7">
							<div class="form-group">
								<label for="">Youtuber ID:</label> <input type="text"
									required
									${isEdit==
									1 ? "readonly" : "" } value="${video.id }" name="id"
									class="form-control"> <small id="helpId"
									class="text-muted">Youtuber ID is required</small>
							</div>
							<div class="form-group">
								<label for="">Video Title:</label> <input type="text" required
									name="title" id="" class="form-control" placeholder=""
									value="${video.title }" aria-describedby="helpId"> <small
									id="helpId" class="text-muted">Video Title is required</small>
							</div>
							<div class="form-group">
								<label for="">View Count:</label> <input type="text" required
									value="${video.views }" name="views" id="" class="form-control"
									placeholder="" aria-describedby="helpId"> <small
									id="helpId" class="text-muted">View Count is required</small>
							</div>
							<div class="form-group">
								<label for="">Status: </label>
								<div class="form-check form-check-inline">
									<label class="form-check-label" for="active"> <input
										class="form-check-input" type="radio" name="active"
										${video.active == 1  ? "checked" : "" } id="active" value="1">Active
									</label>
								</div>
								<div class="form-check form-check-inline">
									<label class="form-check-label" for="inactive"> <input
										${video.active != 1  ? "checked" : "" }
										class="form-check-input" type="radio" name="active"
										id="inactive" value="0">Inactive
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label>Description:</label>
								<textarea class="form-control" rows="" cols="" name="des"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					<button ${isEdit == 1 ? "disabled" : "" }
						formaction="videos/create" class="btn btn-primary">Create</button>
					<button ${isEdit == 0 ? "disabled" : "" }
						formaction="videos/update" class="btn btn-warning">Update</button>
						
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#exampleModal${video.id }">Delete</button> <!-- Modal -->
					<div class="modal fade" id="exampleModal${video.id }" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Delete Video</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">Are you sure delete video has id: ${video.id}</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Cancel</button>
									<a
										href="videos/delete?id=${video.id}"
										class="btn btn-danger">Delete</a>
								</div>
							</div>
						</div>
					</div>
					
					<button formaction="videos" class="btn btn-info">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade show" id="vdlist" role="tabpanel"
		aria-labelledby="vdlist-tab">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Video ID</th>
					<th>Video Title</th>
					<th>View Count</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${videos }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.views }</td>
						<td>${item.active == 1 ? "Active" : "Inactive" }</td>
						<td><a class="btn btn-warning"
							href="videos/edit?id=${item.id }">Edit</a>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</div>