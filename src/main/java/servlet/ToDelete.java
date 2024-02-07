package servlet;

import java.io.IOException;

import dao.DataDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ToDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		int data = DataDAO.deletetDataById(id);
		request.setAttribute("data", data);

		if (data <= 0) {
			request.setAttribute("errorMessage", "家計簿の削除に失敗しました");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/DeleteFalse.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/DeleteSuccess.jsp");
			rd.forward(request, response);
		}

	}
}
