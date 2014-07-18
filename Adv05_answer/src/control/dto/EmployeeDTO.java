package control.dto;

// ユーザ情報を保存するクラス
public class EmployeeDTO {
	private int id;			// ユーザコード
	private String password;	// パスワード
	private String name;		// 氏名
	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　ユーザコード、名前、パスワード。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public EmployeeDTO(int id, String name, String password) {
		setId(id);
		setPassword(password);
		setName(name);
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
}
