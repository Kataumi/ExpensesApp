package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Data;

public class DataDAO {

	private static final String driverName = "com.mysql.cj.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/data_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	//新規登録
	public static boolean reggistData(Data data) {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DBが存在しません");
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "insert into data_table (user_id,day,purpose,price) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, data.getUser_id());
			ps.setString(2, data.getDay());
			ps.setString(3, data.getPurpose());
			ps.setInt(4, data.getPrice());

			int result = ps.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	//閲覧ページで全データを表示するためのメソッド
	public static List<Data> getAllData(int user_id) {
		List<Data> dataList = new ArrayList<>();
		Data data = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

			String sql = "SELECT login_db.login_table.*, data_db.data_table.* "
					+ "FROM login_db.login_table "
					+ "INNER JOIN data_db.data_table "
					+ "ON login_db.login_table.id = data_db.data_table.user_id "
					+ "WHERE login_db.login_table.id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = new Data(
						rs.getInt("user_id"),
						rs.getString("day"),
						rs.getString("purpose"),
						rs.getInt("price"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	//指定したIDに対応するデータをデータベースから取得するためのメソッド
	public static Data getDataById(int id) {
		Data data = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT * FROM data_table WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			//idを見つけたらそれに関連するレコードを取得する
			if (rs.next()) {
				String day = rs.getString("day");
				String purpose = rs.getString("purpose");
				int price = rs.getInt("price");
				data = new Data(id, day, purpose, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	//編集する
	public static int getEdit(int id, String day, String purpose, int price) {
		int result = 0;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "UPDATE data_table SET day=?,purpose=?,price=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, day);
			ps.setString(2, purpose);
			ps.setInt(3, price);
			ps.setInt(4, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	//検索ワードから特定する
	public static List<Data> searchWord(String day, String purpose) {
		List<Data> dataList = new ArrayList<>();
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT * FROM data_table WHERE day = ? OR purpose = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, day);
			ps.setString(2, purpose);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Data data = new Data(rs.getString("day"), rs.getString("purpose"), rs.getInt("price"));
				data.setId(rs.getInt("id"));
				dataList.add(data);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataList;
	}

	//指定したIDを削除する
	public static int deletetDataById(int id) {
		int result = 0;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "DELETE FROM data_table WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
