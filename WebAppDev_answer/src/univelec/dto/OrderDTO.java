package univelec.dto;
import java.sql.*;

/*
 * ����DTO�N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderDTO {
	private int itemNo; // ���i�ԍ�
	private String itemName; // ���i��
	private int no; // �����ԍ�
	private Timestamp orderDate; // ��������
	private int quantity; // ����
	private int userId; // ���[�U�R�[�h

	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@�����ԍ��A���i�ԍ��A���ʁA���[�U�R�[�h�A���������B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
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
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���i�ԍ��A���ʁA���[�U�R�[�h�A���������B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
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
