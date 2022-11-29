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

import ma.fstt.model.Category;
import ma.fstt.model.Product;
import ma.fstt.persistence.CategoryOperations;
import ma.fstt.persistence.ProductOperations;

@WebServlet("")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductOperations productOperations;
	private CategoryOperations categoryOperations;

	public ProductServlet() {
		super();
		productOperations = new ProductOperations();
		categoryOperations = new CategoryOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			if (action == null) {
				listProducts(request, response);
			} else {
				switch (action) {
				case "product":
					showProduct(request, response);
					break;
				default:
					listProducts(request, response);
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

	private void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Product> productList = productOperations.getAllProducts();
		request.setAttribute("productList", productList);

		List<Category> categoryList = categoryOperations.getAllCategories();
		request.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
		dispatcher.forward(request, response);
	}

	private void showProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Find the added product
		Long productId = Long.parseLong(request.getParameter("id"));
		Product product = productOperations.findProduct(productId);
		request.setAttribute("product", product);
		
		List<Category> categoryList = categoryOperations.getAllCategories();
		request.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowProduct.jsp");
		dispatcher.forward(request, response);
	}
}
