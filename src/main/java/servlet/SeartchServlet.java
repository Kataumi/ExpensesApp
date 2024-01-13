package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DataDAO;
import dto.Data;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SeartchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<Data> dataList = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String day = request.getParameter("day");
		String purpose = request.getParameter("purpose");

		List<Data> data = DataDAO.searchWord(day, purpose);

		if (data != null) {
			dataList.addAll(data); //addAllメソッドでdataリストの要素をdataListの要素に追加する
			HttpSession session = request.getSession();
			session.setAttribute("dataList", dataList);
			String nextPage = "WEB-INF/jsp/GetSearch.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}

	}
}
