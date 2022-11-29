<%@page import="ma.fstt.model.CartDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
</head>
<body>
	<jsp:include page="Navbar.jsp" />
	<div class="container">
		<div class="my-5 row">

			<c:if test="${ !isLoggedIn }">
				<div class="card">
					<div class="card-body text-center">
						<img
							src="https://rukminim1.flixcart.com/www/800/800/promos/16/05/2019/d438a32e-765a-4d8b-b4a6-520b560971e8.png?q=90"
							alt="" style="height: 250px; width: 300px;">

						<h6 class="">
							You haven't login. <a href="/app/LoginForm.jsp"> please
								login.</a>
						</h6>
						<a href="/app/LoginForm.jsp" class="btn btn-primary mt-3">Login
							Now</a>
					</div>
				</div>
			</c:if>
			<c:if test="${ isLoggedIn }">
				<c:if test="${ cartDetailList == null }">
					<div class="card">
						<div class="card-body text-center">
							<img
								src="https://rukminim1.flixcart.com/www/800/800/promos/16/05/2019/d438a32e-765a-4d8b-b4a6-520b560971e8.png?q=90"
								alt="" style="height: 250px; width: 300px;">

							<h4 class="">Your cart is empty!</h4>
							<h6 class="">Add item to it now</h6>
							<a href="/app" class="btn btn-primary mt-3">Shop Now</a>
						</div>
					</div>
				</c:if>

				<c:if test="${ cartDetailList != null && cartDetailList.size()>0 }">
					<!-- Cart Products -->
					<div class="col-md-9">
						<div class="card shadow-sm">
							<div class="card-header">
								<h5 class="text-center">My Cart</h5>
							</div>

							<div class="card-body">

								<!-- Products -->
								<c:forEach var="cartDetail" items="${ cartDetailList }">
									<c:forEach var="product" items="${ productList }">
										<c:if
											test="${ cartDetail.product.productId == product.productId }">
											<div class="card mb-3" style="height: 120px; width: 130;">
												<div class="card-body">
													<div
														class="d-flex justify-content-between align-items-center">

														<div
															class="d-flex justify-content-between align-items-center">
															<div
																class="align-self-start d-flex flex-column align-items-center">
																<img class="img-fluid rounded" src="${ product.image }"
																	alt="Product image" style="height: 100px; width: 90;">
															</div>
															<div class="mb-0">
																<div class="d-flex mb-0 justify-content-between">
																	<h5 class="me-3">${ product.productName }</h5>
																</div>
																<p class="mt-0"
																	style="display: -webkit-box; -webkit-line-clamp: 1; -webkit-box-orient: vertical; overflow: hidden; text-overflow: ellipsis;">${
															product.description }</p>
															</div>
														</div>

														<div
															class="d-flex flex-column justify-content-center aligh-items-center">
															<h5 class="me-3 text-center">${ article_panier.prix }</h5>

															<div class="d-flex align-items-center">
																<a type="button" class="btn btn-warning btn-sm me-1"
																	href="/app/cart?action=remove&id=<c:out value="${ product.productId }" />">
																	<i class="fa-solid fa-minus"></i>
																</a>
																<h6 class="mx-1">${ cartDetail.productQuantity }</h6>
																<a type="button" class="btn btn-warning btn-sm ms-1"
																	href="/app/cart?action=add&id=<c:out value="${ product.productId }" />">
																	<i class="fa-solid fa-plus"></i>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:forEach>
							</div>
						</div>
					</div>

					<!-- Total -->
					<div class="col-md-3">
						<div class="card shadow-sm">

							<div class="card-header">
								<h5>Total</h5>
							</div>

							<div class="card-body mt-0">

								<div class="d-flex justify-content-between my-0">
									<p class="mb-3">Sub-Total</p>
									<p class="mb-3"><c:out value="${ cart.itemsPrice }" /></p>
								</div>

								<div class="d-flex justify-content-between my-0">
									<p class="mb-3">Shipping</p>
									<p class="mb-3">$8.50</p>
								</div>

								<hr class="my-0">

								<div class="d-flex justify-content-between my-0">
									<p class="my-3">
										<strong>Estimated Total</strong>
									</p>
									<p class="my-3">
										<strong>${ cart.itemsPrice + 8.5}</strong>
									</p>
								</div>

								<div class="d-grid gap-2">
									<a class="btn btn-primary" href="/app/cart?action=checkout">Checkout</a>
								</div>

							</div>

						</div>
					</div>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
</html>