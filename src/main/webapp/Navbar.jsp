<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page import="ma.fstt.model.Category"%>
<%@ page import="ma.fstt.persistence.CategoryOperations"%>
<%
CategoryOperations categoryOperations = new CategoryOperations();
List<Category> categoryList = categoryOperations.getAllCategories();
String username = (String) request.getSession().getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid mx-3">
			<a class="navbar-brand" href="/app"><i class="fa-solid fa-store"></i>
				My Store</a>

			<ul class="navbar-nav">
				<c:if test="${ username == null }">
					<li class="nav-item"><a class="nav-link"
						href="/app/LoginForm.jsp"><i class="fa-solid fa-user"></i></a></li>
				</c:if>

				<c:if test="${ username != null }">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"><i
							class="fa-solid fa-user"></i> <c:out value="${ username }" /> </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/app/logout">Logout</a></li>
						</ul></li>
				</c:if>

				<li class="nav-item"><a class="nav-link" href="/app/cart">
						<i class="fa-solid fa-cart-shopping"></i>
				</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>