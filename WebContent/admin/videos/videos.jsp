<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="" method="post">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-5">
							<img src="${pageContext.request.contextPath }/images/product.png" width="100%" class="img-fluid p-3 border" alt="404: Image not found">
						</div>
						<div class="col-7">
							<div class="form-group">
								<label for="">Youtuber ID:</label> <input type="text"
									name="ytbId" id="" class="form-control" placeholder=""
									aria-describedby="helpId"> <small id="helpId"
									class="text-muted">Youtuber ID is required</small>
							</div>
							<div class="form-group">
								<label for="">Video Title:</label> <input type="text"
									name="vdTitle" id="" class="form-control" placeholder=""
									aria-describedby="helpId"> <small id="helpId"
									class="text-muted">Video Title is required</small>
							</div>
							<div class="form-group">
								<label for="">View Count:</label> <input type="text"
									name="viewCount" id="" class="form-control" placeholder=""
									aria-describedby="helpId"> <small id="helpId"
									class="text-muted">View Count is required</small>
							</div>
							<div class="form-group">
								<label for="">Status: </label>
								<div class="form-check form-check-inline">
									<label class="form-check-label" for="active"> <input
										class="form-check-input" type="radio" name="status"
										id="active" value="true">Active
									</label>
								</div>
								<div class="form-check form-check-inline">
									<label class="form-check-label" for="inactive"> <input
										class="form-check-input" type="radio" name="status"
										id="inactive" value="false">Inactive
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="des">Description:</label>
								<textarea class="form-control" id="des" rows="8"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					<button class="btn btn-primary">Create</button>
					<button class="btn btn-warning">Update</button>
					<button class="btn btn-danger">Delete</button>
					<button class="btn btn-info">Reset</button>

				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade show" id="vdlist" role="tabpanel"
		aria-labelledby="vdlist-tab">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Youtube ID</th>
					<th>Video Title</th>
					<th>View Count</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Id</td>
					<td>Title</td>
					<td>1000</td>
					<td>Active</td>
					<td><a class="btn btn-warning" href="#">Edit</a> <a
						class="btn btn-danger" href="#">Delete</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>