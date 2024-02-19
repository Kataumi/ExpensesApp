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
		String priceStr = request.getParameter("price");
		int user_id = Integer.parseInt(request.getParameter("user_id"));

		//いずれか、もしくは全てが未入力の場合エラー
		if (day == null || day.isEmpty() ||
				purpose == null || purpose.isEmpty() ||
				priceStr == null || priceStr.isEmpty()) {
			request.setAttribute("errorMessage", "日付、用途、金額を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/CreateFalse.jsp");
			rd.forward(request, response);
			return;
		}
		int price = Integer.parseInt(priceStr);

		Data data = new Data(day, purpose, price, user_id);
		String nextPage = "";

		try {
			boolean flag = DataDAO.reggistData(data);

			if (flag) {
				nextPage = "WEB-INF/jsp/CreateSuccess.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("data", data);
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "家計簿の作成ができませんでした。");
				nextPage = "WEB-INF/jsp/CreateFalse.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
			}
		} catch (IOException e) {
			request.setAttribute("errorMessage", "DBにエラーが発生しました: " + e.getMessage());
			nextPage = "WEB-INF/jsp/Error.jsp";
			System.out.println(e.getMessage());
		}
	}
}
