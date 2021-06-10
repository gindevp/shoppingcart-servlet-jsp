<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item"><a class="nav-link active" id="user-tab"
		data-toggle="tab" href="#user" role="tab" aria-controls="user"
		aria-selected="true">User Editing</a></li>
	<li class="nav-item"><a class="nav-link" id="userlist-tab"
		data-toggle="tab" href="#userlist" role="tab" aria-controls="userlist"
		aria-selected="false">User List</a></li>

</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="user" role="tabpanel"
		aria-labelledby="user-tab">
		<form action="" method="post">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="form-group col">
							<label for="">Username:</label> <input type="text"
								name="username" id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Username is required</small>
						</div>
						<div class="form-group col">
							<label for="">Fullname:</label> <input type="text"
								name="fullname" id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Fullname is required</small>
						</div>
						<div class="col-12"></div>
						<div class="form-group col">
							<label for="">Password:</label> <input type="password"
								name="password" id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Password is required</small>
						</div>
						<div class="form-group col">
							<label for="">Email:</label> <input type="email" name="email"
								id="" class="form-control" placeholder=""
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Email is required</small>
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
	<div class="tab-pane fade show" id="userlist" role="tabpanel"
		aria-labelledby="userlist-tab">
		<table class="table table-striped border">
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