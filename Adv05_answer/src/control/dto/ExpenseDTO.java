package control.dto;
import java.sql.*;

//�o�����ۑ�����N���X
public class ExpenseDTO {
	private int expenseId;		// �o��ID
	private int id;			// ���[�U�R�[�h
	private Date useDate;		// �g�p��
	private String use;			// �p�r
	private int cost;			// ��p
	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@��pID�A���[�U�R�[�h�A�g�p���A�p�r�A��p�B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
	 */
	public ExpenseDTO(int expenseId, int id, Date useDate, String use, int cost) {
		setExpenseId(expenseId);
		setId(id);
		setUseDate(useDate);
		setUse(use);
		setCost(cost);
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
}
