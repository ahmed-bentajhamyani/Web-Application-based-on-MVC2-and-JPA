<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<div class="my-5 row">

			<!-- Alert -->
			<c:if test="${ message != null }">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					${ message }
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>

			<!-- Products -->
			<c:forEach var="product" items="${productList}">
				<div class="col-md-4">
					<div class="card border-0 shadow-sm mb-3"
						style="border-radius: 10px; height: 380px; width: 400;">
						<div class="card-body">
							<div class="text-center">
								<a style="padding: 0; border: none; background: none;"
									href="/app?action=product&id=<c:out value="${ product.productId }" />">
									<img class="img-fluid rounded" src="${ product.image }"
									alt="Product image" style="height: 180px; width: 110;">
								</a>
							</div>
							<div class="mt-3">
								<div class="row">
									<h5 class="mb-1 col-md-8">
										<c:out value="${ product.productName }" />
									</h5>
									<p class="mb-1 col-md-4">
										<c:out value="${ product.price }" />
									</p>
								</div>
								<p
									style="display: -webkit-box; -webkit-line-clamp: 3; -webkit-box-orient: vertical; overflow: hidden; text-overflow: ellipsis;">
									<c:out value="${ product.description }" />
								</p>

								<div class="text-center">
									<a class="btn btn-primary btn-sm mx-1"
										href="/app?action=product&id=<c:out value="${ product.productId }" />">
										<i class="fa-solid fa-circle-info"></i> More Details
									</a> <a class="btn btn-success btn-sm mx-1"
										href="/app/cart?action=add&id=<c:out value="${ product.productId }" />">
										<i class="fa-solid fa-cart-shopping"></i> Add to Cart
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>