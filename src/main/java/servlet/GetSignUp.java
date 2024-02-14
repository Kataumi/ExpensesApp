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

public class GetSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//新規登録
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		//名前かパスワードか両方が未入力の場合エラー
		if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
			request.setAttribute("errorMessage", "名前とパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/SignUpFalse.jsp");
			rd.forward(request, response);
			return; //エラーページに遷移後にreturnしているので、これ以降の処理はされない
		}

		//パスワードがASCII文字のみで構成されていない場合にtrueを返す(全角入力時エラー)
		if (!password.matches("^[\\p{ASCII}]*$")) {
			request.setAttribute("errorMessage", "パスワードは半角文字で入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/SignUpFalse.jsp");
			rd.forward(request, response);
			return;

		}

		User user = new User(name, password);

		boolean flag = UsersDAO.reggistUser(user);
		String nextPage = "";

		try {
			if (flag) {
				nextPage = "WEB-INF/jsp/SignUpSuccess.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "新規登録できませんでした。");
				nextPage = "WEB-INF/jsp/SignUpFalse.jsp";
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
