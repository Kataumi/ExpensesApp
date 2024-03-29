package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Hash;
import dto.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UsersDAO {

	private static final String driverName = "com.mysql.cj.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/login_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	//新規登録
	public static boolean reggistUser(User user) {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("テーブルが見つかりません。" + e.getMessage());
			return false;
		}

		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

			//名前が重複していないかの確認
			String checkName = "select * from login_table where name = ?";
			PreparedStatement checkps = con.prepareStatement(checkName);
			checkps.setString(1, user.getName());
			ResultSet rs = checkps.executeQuery();
			if (rs.next()) {
				return false;
			}

			//サインアップ処理
			String sql = "insert into login_table (name,password) values (?,?)";
			String hashedPassword = Hash.hashPassword(user.getPassword());
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, hashedPassword);
			int result = ps.executeUpdate();

			if (result != 1) {
				return false;

			}
		} catch (SQLException e) {
			System.out.println("データベースエラーが発生。" + e.getMessage());
			return false;
		}
		return true;
	}

	//ログイン処理
	public static User loginUser(String name, String password, HttpServletRequest request) {
		User user = null;
		int user_id = 0;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT * FROM login_table WHERE name = ? AND password = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			String hashedPassword = Hash.hashPassword(password);

			ps.setString(1, name);
			ps.setString(2, hashedPassword);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(
						rs.getString("name"),
						rs.getString("password"));
				user_id = rs.getInt("id");

				HttpSession session = request.getSession();
				session.setAttribute("user_id", user_id);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
