package servlet;

import java.io.IOException;

import dao.DataDAO;
import dto.Data;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String day = request.getParameter("day");
		String purpose = request.getParameter("purpose");
		int price = Integer.parseInt(request.getParameter("price"));

		Data data = new Data(day, purpose, price);
		boolean flag = DataDAO.reggistData(data);

		String nextPage = "";

		if (flag) {
			nextPage = "WEB-INF/jsp/createSuccess.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("data", data);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}
}
