package control.dto;

//電話番号情報を保存するクラス
public class ContactDTO {
	private int id;		// ユーザコード
	private int extension;	// 内線番号
	private String mobile;	// 携帯番号
	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　ユーザコード、内線番号、携帯番号。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public ContactDTO(int id, int extension, String mobile) {
		this.id = id;
		this.extension = extension;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExtension() {
		return extension;
	}
	public void setExtension(int extension) {
		this.extension = extension;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}