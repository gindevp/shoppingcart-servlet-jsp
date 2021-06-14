<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form class="col-6 mx-auto" action="" method="post">
	<div class="card">
		<div class="card-header">Send video to your friend</div>
		<div class="card-body">
			<div class="row">
				<jsp:include page="/sites/common/inform.jsp"></jsp:include>
			</div>
			<div class="form-group">
				<label for="">Your friend email:</label> <input type="email" name="email"
					id="" class="form-control" placeholder="" aria-describedby="helpId">
				<small id="helpId" class="text-muted">Email is required</small>
			</div>
		</div>
		<div class="card-footer">
			<button type="submit" class="btn btn-success">Send</button>
		</div>
	</div>
</form>