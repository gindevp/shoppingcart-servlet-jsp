<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item"><a class="nav-link ${isSelectTab1 ? "active" : ""}" id="fav-tab"
		data-toggle="tab" href="#fav" role="tab" aria-controls="fav"
		aria-selected="true">Favorites</a></li>
	<li class="nav-item"><a class="nav-link ${isSelectTab2 ? "active" : ""}" id="favUsers-tab"
		data-toggle="tab" href="#favUsers" role="tab" aria-controls="favUsers"
		aria-selected="false">Favorite Users</a></li>
	<li class="nav-item"><a class="nav-link ${isSelectTab3 ? "active" : ""}" id="share-tab"
		data-toggle="tab" href="#share" role="tab" aria-controls="share"
		aria-selected="false">Share Friends</a></li>
</ul>
<div class="tab-content" id="myTabContent">
	<div class="tab-pane fade show ${isSelectTab1 ? "active" : ""}" id="fav" role="tabpanel"
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
				<c:forEach var="item" items="${favVideos }">
					<tr>
						<td>${item[0] }</td>
						<td>${item[1] }</td>
						<td>${item[2] }</td>
						<td>${item[3] }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="tab-pane fade show ${isSelectTab2 ? "active" : ""}" id="favUsers" role="tabpanel"
		aria-labelledby="favUsers-tab">
		<form action="reports/favuser" method="get">
			<div class="form-inline my-4">
				<label class="mx-2" for="">Video Title: </label>
				<div class="form-group">
					<select class="form-control mx-2" id="" name="videoUserId">
						<c:forEach var="video" items="${videos }">
							<option ${video.id == videoSelected ? "selected" : "" } value="${video.id }">${video.title }</option>
						</c:forEach>
					</select>
				</div>
				<button class="btn btn-info mx-2">Report</button>
			</div>
		</form>
		
		<table class="table table-striped border">
			<thead>
				<tr>
					<th>Username</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Favorite Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${favUser }">
					<tr>
						<td>${item[0] }</td>
						<td>${item[1] }</td>
						<td>${item[2] }</td>
						<td>${item[3] }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="tab-pane fade show ${isSelectTab3 ? "active" : ""}" id="share" role="tabpanel"
		aria-labelledby="share-tab">
		<form action="" method="post">
			<div class="form-inline my-4">
				<label class="mx-2" for="">Video Title: </label>
				<div class="form-group">
					<select class="form-control mx-2" id="exampleFormControlSelect1">
						<c:forEach var="video" items="${videos }">
							<option value="${video.id }">${video.title }</option>
						</c:forEach>
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
