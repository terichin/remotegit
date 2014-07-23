package univelec.dto;

/*
 * ユーザDTOクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserDTO {

	private int id; // ユーザコード
	private String kana; // かな
	private String mail; // メールアドレス
	private String name; // 氏名
	private String password; // パスワード
	private int privilege; // ユーザ権限
	private String phone; // 電話番号

	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　ユーザコード、パスワード。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public UserDTO(int id, String password) {
		setId(id);
		setPassword(password);
	}

	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　ユーザコード、氏名、電話番号、メールアドレス。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public UserDTO(int id, String name, String phone, String mail) {
		setId(id);
		setName(name);
		setPhone(phone);
		setMail(mail);
	}

	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　氏名、かな、電話番号、メールアドレス、パスワード、ユーザ権限。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public UserDTO(String name, String kana, String phone, String mail,
			String password, int privilege) {
		setName(name);
		setKana(kana);
		setPhone(phone);
		setMail(mail);
		setPassword(password);
		setPrivilege(privilege);
	}
	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　ユーザコード、氏名、かな、電話番号、メールアドレス、ユーザ権限。
	 * 解　説：　引数の情報をそれぞれ保持する。
	 */
	public UserDTO(int id, String name, String kana, String phone, String mail,
			String password, int privilege) {
		setId(id);
		setName(name);
		setKana(kana);
		setPhone(phone);
		setMail(mail);
		setPassword(password);
		setPrivilege(privilege);
	}

	public int getId() {
		return id;
	}

	public String getKana() {
		return kana;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getPrivilege() {
		return privilege;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
