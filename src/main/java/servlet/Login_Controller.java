package servlet;

import java.io.IOException;

import dao.UsersDAO;
import dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		User user = UsersDAO.loginUser(name, password);

		String nextPage = "";

		if (user.getName().equals(name) && user.getPassword().equals(password)) {
			nextPage = "WEB-INF/jsp/LoginSuccess.jsp";
			request.setAttribute("user", user);
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

}
