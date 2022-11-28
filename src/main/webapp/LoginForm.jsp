<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<div class="my-5">
			<div class="card">
				<div class="card-header">Login</div>
				<div class="card-body">
					<form action="/app/login" method="post" class="m-3">
						<div class="mb-3">
							<label class="form-label">Username</label> <input type="text"
								class="form-control" name="username">
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" name="password">
						</div>
						<div class="form-text mb-2">
							<a href="/app/SignupForm.jsp">Don't have an account?</a>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>