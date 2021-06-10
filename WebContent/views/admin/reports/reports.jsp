<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item"><a class="nav-link active" id="fav-tab"
		data-toggle="tab" href="#fav" role="tab" aria-controls="fav"
		aria-selected="true">Favorites</a></li>
	<li class="nav-item"><a class="nav-link" id="favUsers-tab"
		data-toggle="tab" href="#favUsers" role="tab" aria-controls="favUsers"
		aria-selected="false">Favorite Users</a></li>
	<li class="nav-item"><a class="nav-link" id="share-tab"
		data-toggle="tab" href="#share" role="tab" aria-controls="share"
		aria-selected="false">Share Friends</a></li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show active" id="fav" role="tabpanel"
		aria-labelledby="fav-tab">
		<table class="table table-striped border">
			<thead>
				<tr>
					<th>Video Title</th>
					<th>Favorites Count</th>
					<th>Lasted Date</th>
					<th>Oldest Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="tab-pane fade show" id="favUsers" role="tabpanel"
		aria-labelledby="favUsers-tab">
		<form action="" method="post">
			<div class="form-inline my-4">
				<label class="mx-2" for="">Video Title: </label>
				<div class="form-group">
					<select class="form-control mx-2" id="exampleFormControlSelect1">
						<option>Hello world!</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
				<button class="btn btn-info mx-2">Report</button>
			</div>
		</form>
		<table class="table table-striped border">
			<thead>
				<tr>
					<th>Video Title</th>
					<th>Favorites Count</th>
					<th>Lasted Date</th>
					<th>Oldest Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="tab-pane fade show" id="share" role="tabpanel"
		aria-labelledby="share-tab">
		<form action="" method="post">
			<div class="form-inline my-4">
				<label class="mx-2" for="">Video Title: </label>
				<div class="form-group">
					<select class="form-control mx-2" id="exampleFormControlSelect1">
						<option>Hello world!</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
				<button class="btn btn-info mx-2">Report</button>
			</div>
		</form>
		<table class="table table-striped border">
			<thead>
				<tr>
					<th>Sender Name</th>
					<th>Sender Email</th>
					<th>Recieve Email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
