package control.dto;

//�d�b�ԍ�����ۑ�����N���X
public class ContactDTO {
	private int id;		// ���[�U�R�[�h
	private int extension;	// �����ԍ�
	private String mobile;	// �g�єԍ�
	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���[�U�R�[�h�A�����ԍ��A�g�єԍ��B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
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