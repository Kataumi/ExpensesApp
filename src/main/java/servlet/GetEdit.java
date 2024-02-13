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

public class GetEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String day = request.getParameter("day");
		String purpose = request.getParameter("purpose");
		int price = Integer.parseInt(request.getParameter("price"));

		Data data = new Data(id, day, purpose, price, user_id);
		int result = DataDAO.getEdit(data.getId(), data.getUser_id(),
				data.getDay(), data.getPurpose(), data.getPrice());

		if (result <= 0) {
			request.setAttribute("errorMessage", "家計簿の更新に失敗しました");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/EditFalse.jsp");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("data", data);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/EditSuccess.jsp");
			rd.forward(request, response);
		}
	}

}
