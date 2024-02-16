package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ToCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("user_id");

		try {

			if (user_id != null) {
				request.setAttribute("user_id", user_id);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Create.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("user_idが見つかりません");
			}
		} catch (IOException e) {
			request.setAttribute("errorMessage", "エラーが発生しました: " + e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Error.jsp");
			rd.forward(request, response);

		}
	}

}
