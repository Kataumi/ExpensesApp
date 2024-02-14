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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//		int id = Integer.parseInt(request.getParameter("id"));
		//		int price = Integer.parseInt(request.getParameter("price"));
		
		String idStr = request.getParameter("id");
		int id = idStr != null && !idStr.isEmpty() ? Integer.parseInt(idStr) : 0;

		String priceStr = request.getParameter("price");
		int price = priceStr != null && !priceStr.isEmpty() ? Integer.parseInt(priceStr) : 0;

		String day = request.getParameter("day");
		String purpose = request.getParameter("purpose");
		
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");

		List<Data> data = DataDAO.searchWord(id, day, purpose, price,user_id);
		ArrayList<Data> dataList = new ArrayList<>();

		if (data != null && !data.isEmpty()) {
			dataList.addAll(data); //addAllメソッドでdataリストの要素をdataListの要素に追加する

			request.setAttribute("dataList", dataList);

			String nextPage = "WEB-INF/jsp/GetSearch.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} else {
			request.setAttribute("errorMessage", "検索結果がありませんでした");
			String nextPage = "WEB-INF/jsp/NotSearch.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}

	}
}
