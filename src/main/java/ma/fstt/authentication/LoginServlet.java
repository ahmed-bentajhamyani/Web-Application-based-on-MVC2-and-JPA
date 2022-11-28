package ma.fstt.authentication;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.fstt.persistence.UserOperations;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserOperations userOperations;

	public LoginServlet() {
		super();
		userOperations = new UserOperations();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		validateUsernamePassword(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void validateUsernamePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean valid = userOperations.validate(request.getParameter("username"), request.getParameter("password"));
		if (valid) {
			String username = request.getParameter("username");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);	
			
			response.sendRedirect("/app");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginForm.jsp");
			dispatcher.forward(request, response);
		}
	}
}
