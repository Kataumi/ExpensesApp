package servlet;

import java.io.IOException;
import java.util.List;

import dao.DataDAO;
import dto.Data;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ToView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		String nextPage = "";
		
		try {
			List<Data> dataList = DataDAO.getAllData(user_id);
			request.setAttribute("dataList", dataList);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/View.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			request.setAttribute("errorMessage", "DBにエラーが発生しました: " + e.getMessage());
			nextPage = "WEB-INF/jsp/Error.jsp";
			System.out.println(e.getMessage());
			
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}

}
