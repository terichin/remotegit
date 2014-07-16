package dto;

// 従業員情報を保存するクラス
public class EmployeeDTO {
	private int id;			// 従業員ID
	private String password;	// パスワード
	private String name;		// 氏名
	// コンストラクタでは全カラムの情報を引数で受け取る
	public EmployeeDTO(int id, String name, String password) {
		// 各カラムの情報をsetterを使用してメンバ変数にsetする
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