package dto;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String password;
	private String day;
	private String purpose;
	private int price;

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(int id, String name, String password, String day, String purpose, int price) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
