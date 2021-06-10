<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form class="col-6 mx-auto" action="" method="post">
	<div class="card">
		<div class="card-header">
			<h5 class="text-primary">FORGOT PASSWORD</h5>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="">Username:</label> <input type="text" name="username"
					id="" class="form-control" placeholder="" aria-describedby="helpId">
				<small id="helpId" class="text-muted">Username is required</small>
			</div>

			<div class="form-group">
				<label for="">Email:</label> <input type="email" name="email" id=""
					class="form-control" placeholder="" aria-describedby="helpId">
				<small id="helpId" class="text-muted">Email is required</small>
			</div>

		</div>
		<div class="card-footer text-right">
			<button class="btn btn-primary">Retrive</button>
		</div>
	</div>
</form>