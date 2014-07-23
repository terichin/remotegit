package univelec.dto;

/*
 * ���[�UDTO�N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserDTO {

	private int id; // ���[�U�R�[�h
	private String kana; // ����
	private String mail; // ���[���A�h���X
	private String name; // ����
	private String password; // �p�X���[�h
	private int privilege; // ���[�U����
	private String phone; // �d�b�ԍ�

	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���[�U�R�[�h�A�p�X���[�h�B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
	 */
	public UserDTO(int id, String password) {
		setId(id);
		setPassword(password);
	}

	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���[�U�R�[�h�A�����A�d�b�ԍ��A���[���A�h���X�B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
	 */
	public UserDTO(int id, String name, String phone, String mail) {
		setId(id);
		setName(name);
		setPhone(phone);
		setMail(mail);
	}

	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@�����A���ȁA�d�b�ԍ��A���[���A�h���X�A�p�X���[�h�A���[�U�����B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
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
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���[�U�R�[�h�A�����A���ȁA�d�b�ԍ��A���[���A�h���X�A���[�U�����B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
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
