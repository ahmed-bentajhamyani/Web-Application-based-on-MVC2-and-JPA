<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${ product.productName }</title>
</head>
<body>
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<div class="my-5 row">
			<div class="col-md-12">
				<div class="card border-0 shadow-sm" style="border-radius: 10px;">
					<div class="card-body">
						<div class="d-flex rounded">

							<div class="mx-5 my-3 col-md-5 px-3 py-3">
								<img class="img-fluid rounded"
									src="${ product.image }"
									alt="Product image">
							</div>
							<div class="d-flex flex-column justify-content-center my-5">
								<div class="mx-3 my-auto">

									<div
										class="d-flex align-items-center justify-content-between mb-0">
										<h3 class="mb-0">${ product.productName }</h3>
										<p class="mb-0">${ product.price }</p>
									</div>

									<c:forEach var="category" items="${categoryList}">
										<c:if
											test="${ product.category.categoryId == category.categoryId }">
											<p class="my-0">${ category.categoryName }</p>
										</c:if>
									</c:forEach>
									<h5 class="mt-2">${ product.description }</h5>
									<div
										class="d-flex align-items-center justify-content-between mb-0">
										<h6 class="text-success">${ product.quantity }items left</h6>
									</div>
								</div>

								<div class="d-flex justify-content-center my-5 d-grid">
									<a class="btn btn-success btn-sm mx-1" href="/app/cart?action=add&id=<c:out value="${ product.productId }" />">
										<i class="fa-solid fa-cart-shopping"></i> Add to Cart
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>