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

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Data> dataList = DataDAO.getAllData();
		request.setAttribute("dataList", dataList);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/View.jsp");
		rd.forward(request, response);
	}

}
