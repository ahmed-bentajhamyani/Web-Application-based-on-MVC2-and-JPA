package ma.fstt.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.model.Cart;
import ma.fstt.model.User;
import ma.fstt.persistence.UserOperations;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserOperations userOperations = new UserOperations();

		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Cart cart = new Cart(0);

		User newUser = new User(email, username, password, true, cart);
		userOperations.signUpUser(newUser);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		response.sendRedirect("/app/");
	}
}
