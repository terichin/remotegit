package univelec.dto;

/*
 * 商品DTOクラス
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemDTO {

	private int category; // カテゴリ
	private String name; // 商品名
	private int no; // 商品番号
	private int price; // 価格
	private int stock; // 在庫数

	public ItemDTO(int no, String name, int price) {
		setNo(no);
		setName(name);
		setPrice(price);
	}
	
	public int getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	public int getPrice() {
		return price;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
