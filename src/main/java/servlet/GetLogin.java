package servlet;

import java.io.IOException;

import dao.UsersDAO;
import dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		//名前かパスワードか両方が未入力の場合エラー
		if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
			request.setAttribute("errorMessage", "名前とパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/LoginFalse.jsp");
			rd.forward(request, response);
			return; //エラーページに遷移後にreturnしているので、これ以降の処理はされない
		}

		User user = UsersDAO.loginUser(name, password, request);

		String nextPage = "";
		try {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				nextPage = "WEB-INF/jsp/LoginSuccess.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "ログインできませんでした。");
				nextPage = "WEB-INF/jsp/LoginFalse.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			request.setAttribute("errorMessage", "エラーが発生しました: " + e.getMessage());
			nextPage = "WEB-INF/jsp/Error.jsp";
			
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);

		}
	}

}
