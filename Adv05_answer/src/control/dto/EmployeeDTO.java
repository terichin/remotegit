package control.dto;

// ���[�U����ۑ�����N���X
public class EmployeeDTO {
	private int id;			// ���[�U�R�[�h
	private String password;	// �p�X���[�h
	private String name;		// ����
	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���[�U�R�[�h�A���O�A�p�X���[�h�B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
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
