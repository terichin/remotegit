package control.dto;
import java.sql.*;

//経費情報を保存するクラス
public class ExpenseDTO {
	private int expenseId;		// 経費ID
	private int id;			// ユーザコード
	private Date useDate;		// 使用日
	private String use;			// 用途
	private int cost;			// 費用
	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　費用ID、ユーザコード、使用日、用途、費用。
	 * 解　説：　引数の情報をそれぞれ保持する。
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
