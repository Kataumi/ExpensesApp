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

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		int user_id = Integer.parseInt(request.getParameter("user_id"));
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		List<Data> dataList = DataDAO.getAllData(user_id);
		request.setAttribute("dataList", dataList);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/View.jsp");
		rd.forward(request, response);
	}

}
