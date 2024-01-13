package servlet;

import java.io.IOException;

import dao.UsersDAO;
import dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//新規登録
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		User user = new User(name, password);

		boolean flag = UsersDAO.reggistUser(user);

		String nextPage = "";

		if (flag) {
			nextPage = "WEB-INF/jsp/ReggistSuccess.jsp";
			request.setAttribute("user", user);

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);

		}
	}
}
