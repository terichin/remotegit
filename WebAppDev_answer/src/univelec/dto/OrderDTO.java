package univelec.dto;
import java.sql.*;

/*
 * 注文DTOクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderDTO {
	private int itemNo; // 商品番号
	private String itemName; // 商品名
	private int no; // 注文番号
	private Timestamp orderDate; // 注文日時
	private int quantity; // 数量
	private int userId; // ユーザコード

	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　注文番号、商品番号、数量、ユーザコード、注文日時。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public OrderDTO(int no, int itemNo, String itemName, int quantity,
			int userId, Timestamp orderDate) {
		setNo(no);
		setItemNo(itemNo);
		setItemName(itemName);
		setQuantity(quantity);
		setUserId(userId);
		setOrderDate(orderDate);
	}

	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　商品番号、数量、ユーザコード、注文日時。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public OrderDTO(int itemNo, String itemName, int quantity,
			int id, Timestamp orderDate) {
		this(0, itemNo, itemName, quantity, id, orderDate);
	}

	public int getItemNo() {
		return itemNo;
	}
	public int getNo() {
		return no;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
