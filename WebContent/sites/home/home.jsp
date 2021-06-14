<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<section class="col-9">
	<div class="row d-flex justify-content-left">
		<c:forEach var="item" items="${videos }">
			<div class="card mx-3 mb-3" style="width: 15rem;">
				<img class="card-img-top" height="120rem"
					src="images/${item.poster != null ? item.poster : 'default.jpg' }"
					alt="Card image cap">
				<div class="card-body">
					<h4 class="card-title">${item.title }</h4>
				</div>
				<div class="card-footer text-right">
					<a class="btn btn-primary"
						href="sites/like_video?videoId=${item.id }">Like</a>
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#exampleModal${item.id }">Share</button>
					<!-- Modal -->
					<div class="modal fade" id="exampleModal${item.id }" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Type
										friend's email you want share <span class="text-info">${item.title }</span>: </h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<input class="form-control" placeholder="Type email..."
											type="email" name="email" required>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Cancel</button>
									<a href="sites/home/share?videoId=${item.id}"
										class="btn btn-info">Send</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</section>

<aside class="col-3">
	<div class="card row">
		<div class="card-header text-danger">
			<i class="fas fa-heart"></i> Favorite
		</div>
		<ul class="list-group">
			<li class="list-group-item">Item 1</li>
			<li class="list-group-item">Item 2</li>
			<li class="list-group-item">Item 3</li>
			<li class="list-group-item">Item 4</li>
		</ul>
	</div>
</aside>

<nav class="mx-auto my-4" aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</nav>