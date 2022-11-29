package ma.fstt.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.fstt.model.Cart;
import ma.fstt.model.CartDetail;
import ma.fstt.model.Product;
import ma.fstt.persistence.CartDetailOperations;
import ma.fstt.persistence.CartOperations;
import ma.fstt.persistence.ProductOperations;
import ma.fstt.persistence.UserOperations;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartOperations cartOperations;
	private CartDetailOperations cartDetailOperations;
	private UserOperations userOperations;
	private ProductOperations productOperations;

	public CartServlet() {
		super();
		cartOperations = new CartOperations();
		cartDetailOperations = new CartDetailOperations();
		userOperations = new UserOperations();
		productOperations = new ProductOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			if (action == null) {
				showCart(request, response);
			} else {
				switch (action) {
				case "add":
					addToCart(request, response);
					break;
				case "remove":
					removeFromCart(request, response);
					break;
				case "checkout":
					checkOut(request, response);
					break;
				default:
					showCart(request, response);
					break;
				}
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();
		String loggedIn = (String) session.getAttribute("username");
		if (loggedIn != null) {
			// Get the cart
			String username = (String) session.getAttribute("username");
			Long cartId = userOperations.findUserByUsername(username).getCart().getCartId();
			Cart cart = cartOperations.findCart(cartId);
			request.setAttribute("cart", cart);

			ProductOperations productOperations = new ProductOperations();
			List<Product> productList = productOperations.getAllProducts();
			request.setAttribute("productList", productList);

			CartDetailOperations cartDetailOperations = new CartDetailOperations();
			List<CartDetail> cartDetailList = cartDetailOperations.getProductOfCart(cart);
			request.setAttribute("cartDetailList", cartDetailList);

			request.setAttribute("isLoggedIn", true);
		} else {
			request.setAttribute("isLoggedIn", false);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
		dispatcher.forward(request, response);
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();

		// Get the cart
		String username = (String) session.getAttribute("username");
		Cart cart = userOperations.findUserByUsername(username).getCart();

		// Find the added product
		Long productId = Long.parseLong(request.getParameter("id"));
		Product product = productOperations.findProduct(productId);

		// Set the items price in the cart
		System.out.println(cart.getItemsPrice());
		System.out.println(product.getPrice());
		float itemsPrice = cart.getItemsPrice() + product.getPrice();
		System.out.println(itemsPrice);
		cartOperations.updateItemsPrice(cart, itemsPrice);

		// Add the product to the cart
		boolean founded = false;
		List<CartDetail> cartDetails = cartDetailOperations.getProductOfCart(cart);
		if (cartDetails != null && cartDetails.size() > 0) {
			for (CartDetail cd : cartDetails) {
				if (cd.getProduct().getProductId() == product.getProductId()) {
					cartDetailOperations.addQuantity(cd);
					founded = true;
				}
			}
		}
		if (!founded) {
			CartDetail cartDetail = new CartDetail(1, cart, product);
			cartDetailOperations.addToCart(cartDetail);
		}

		response.sendRedirect("/app/cart");
	}

	private void removeFromCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();

		// Get the cart
		String username = (String) session.getAttribute("username");
		Cart cart = userOperations.findUserByUsername(username).getCart();

		// Find the removed product
		Long productId = Long.parseLong(request.getParameter("id"));
		Product product = productOperations.findProduct(productId);

		// Remove the product from the cart
		List<CartDetail> cartDetails = cartDetailOperations.getProductOfCart(cart);
		if (cartDetails != null && cartDetails.size() > 0) {
			for (CartDetail cd : cartDetails) {
				if (cd.getProduct().getProductId() == product.getProductId())
					if (cd.getProductQuantity() > 1)
						cartDetailOperations.subtractQuantity(cd);
					else
						cartDetailOperations.deleteFromCart(cd);
			}
		}

		// Set the items price in the cart
		System.out.println(cart.getItemsPrice());
		System.out.println(product.getPrice());
		float itemsPrice = cart.getItemsPrice() - product.getPrice();
		System.out.println(itemsPrice);
		cartOperations.updateItemsPrice(cart, itemsPrice);

		response.sendRedirect("/app/cart");
	}

	private void checkOut(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession session = request.getSession();

		// Get the cart
		String username = (String) session.getAttribute("username");
		Cart cart = userOperations.findUserByUsername(username).getCart();

		// Empty the cart
		List<CartDetail> cartDetails = cartDetailOperations.getProductOfCart(cart);
		if (cartDetails != null && cartDetails.size() > 0) {
			for (CartDetail cd : cartDetails) {
				cartDetailOperations.deleteCartDetail(cd);
			}
		}

		// Set the items price in the cart
		cartOperations.updateItemsPrice(cart, 0);

		String message = "Transaction completed successfully";
		request.setAttribute("message", message);
		List<Product> productList = productOperations.getAllProducts();
		request.setAttribute("productList", productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
		dispatcher.forward(request, response);
	}
}
