package servlet;

import java.io.IOException;

import dao.DataDAO;
import dto.Data;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Data data = DataDAO.getDataById(id);
		
		request.setAttribute("data", data);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Edit.jsp");
		dispatcher.forward(request, response);
	}
}
