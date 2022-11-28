<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<div class="my-5">
			<div class="card">
				<div class="card-header">Signup</div>
				<div class="card-body">
					<form action="/app/signup" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="email" class="form-control" name="email"
								id="exampleInputEmail1" aria-describedby="emailHelp">
							<div id="emailHelp" class="form-text">We'll never share
								your email with anyone else.</div>
						</div>
						<div class="mb-3">
							<label class="form-label">Username</label> <input type="text"
								class="form-control" name="username">
						</div>
						<div class="mb-3">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" name="password">
						</div>
						<div class="form-text mb-2">
							<a href="/app/LoginForm.jsp">Have an account?</a>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>