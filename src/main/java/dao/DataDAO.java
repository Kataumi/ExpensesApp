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
			String sql = "insert into data_table (day,purpose,price) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, data.getDay());
			ps.setString(2, data.getPurpose());
			ps.setInt(3, data.getPrice());

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

	//検索ワードから特定する
	public static List<Data> searchWord(String day, String purpose) {
		List<Data> dataList = new ArrayList<>();
		Data data = null;
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

			if (rs.next()) {
				data = new Data(rs.getString("day"), rs.getString("purpose"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// データが空でない場合、その内容をログに出力
		if (!dataList.isEmpty()) {
			System.out.println("Data found: " + dataList);
		} else {
			System.out.println("No data found for the given day and purpose.");
		}
		return dataList;
	}
}
