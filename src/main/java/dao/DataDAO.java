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

	//家計簿の作成
	public static boolean reggistData(Data data) {

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "insert into data_table (day,purpose,price,user_id) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, data.getDay());
			ps.setString(2, data.getPurpose());
			ps.setInt(3, data.getPrice());
			ps.setInt(4, data.getUser_id());

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

			String sql = "SELECT login_db.login_table.name AND password, data_db.data_table.* "
					+ "FROM login_db.login_table "
					+ "INNER JOIN data_db.data_table "
					+ "ON login_db.login_table.id = data_db.data_table.user_id "
					+ "WHERE login_db.login_table.id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = new Data(
						rs.getInt("id"),
						rs.getString("day"),
						rs.getString("purpose"),
						rs.getInt("price"),
						rs.getInt("user_id"));
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
				int user_id = rs.getInt("user_id");
				data = new Data(id, day, purpose, price, user_id);
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
	public static List<Data> searchWord(int id, String day, String purpose, int price, int user_id) {
		List<Data> dataList = new ArrayList<>();
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

			String sqlId = "SELECT * FROM data_table WHERE user_id = ? AND id = ?";
			String sqlDay = "SELECT * FROM data_table WHERE user_id = ? AND day = ?";
			String sqlPurpose = "SELECT * FROM data_table WHERE user_id = ? AND purpose = ?";
			String sqlPrice = "SELECT * FROM data_table WHERE user_id = ? AND price = ?";

			//IDで検索
			{
				PreparedStatement ps = con.prepareStatement(sqlId);
				ps.setInt(1, user_id);
				ps.setInt(2, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data data = new Data(
							rs.getInt("id"),
							rs.getString("day"),
							rs.getString("purpose"),
							rs.getInt("price"),
							rs.getInt("user_id"));
					data.setId(rs.getInt("id"));
					dataList.add(data);
				}
			}

			//日付で検索
			{
				PreparedStatement ps = con.prepareStatement(sqlDay);
				ps.setInt(1, user_id);
				ps.setString(2, day);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data data = new Data(
							rs.getInt("id"),
							rs.getString("day"),
							rs.getString("purpose"),
							rs.getInt("price"),
							rs.getInt("user_id"));
					data.setId(rs.getInt("id"));
					dataList.add(data);
				}
			}

			//用途で検索
			{
				PreparedStatement ps = con.prepareStatement(sqlPurpose);
				ps.setInt(1, user_id);
				ps.setString(2, purpose);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data data = new Data(
							rs.getInt("id"),
							rs.getString("day"),
							rs.getString("purpose"),
							rs.getInt("price"),
							rs.getInt("user_id"));
					data.setId(rs.getInt("id"));
					dataList.add(data);
				}
			}

			//金額で検索
			{
				PreparedStatement ps = con.prepareStatement(sqlPrice);
				ps.setInt(1, user_id);
				ps.setInt(2, price);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Data data = new Data(
							rs.getInt("id"),
							rs.getString("day"),
							rs.getString("purpose"),
							rs.getInt("price"),
							rs.getInt("user_id"));
					data.setId(rs.getInt("id"));
					dataList.add(data);
				}
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
