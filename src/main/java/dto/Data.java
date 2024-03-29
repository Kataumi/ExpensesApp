package dto;

import java.io.Serializable;

public class Data implements Serializable {

	private int id;
	private String day;
	private String purpose;
	private int price;
	private int user_id;

	//GetCreateの家計簿作成
	public Data(String day, String purpose, int price, int user_id) {
		super();
		this.day = day;
		this.purpose = purpose;
		this.price = price;
		this.user_id = user_id;
	}

	//ViewServletの家計簿閲覧用
	public Data(int id, String day, String purpose, int price, int user_id) {
		super();
		this.id = id;
		this.day = day;
		this.purpose = purpose;
		this.price = price;
		this.user_id = user_id;
	}

	//GetEditの家計簿更新、詳細検索用
	public Data(int id, String day, String purpose, int price) {
		super();
		this.id = id;
		this.day = day;
		this.purpose = purpose;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//	@Override
	//	//dataListの内容を日本語に直すメソッド
	//	//dto.Data@17c0e322から読める文字に変換する
	//	public String toString() {
	//		return "Data{" + "day='" + day + '\'' + ", purpose='" + purpose + '\'' + '}';
	//	}

}
