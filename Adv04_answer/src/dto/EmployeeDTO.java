package dto;

// �]�ƈ�����ۑ�����N���X
public class EmployeeDTO {
	private int id;			// �]�ƈ�ID
	private String password;	// �p�X���[�h
	private String name;		// ����
	// �R���X�g���N�^�ł͑S�J�����̏��������Ŏ󂯎��
	public EmployeeDTO(int id, String name, String password) {
		// �e�J�����̏���setter���g�p���ă����o�ϐ���set����
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