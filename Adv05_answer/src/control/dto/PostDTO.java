package control.dto;

//��������ۑ�����N���X
public class PostDTO {
	private int id;			// ���[�U�R�[�h
	private String postName;	// ������
	private int bossid;		// ��iID
	/*
	 * �@�@�\�F�@�R���X�g���N�^�B
	 *
	 * ���@���F�@���[�U�R�[�h�A�������A��iID�B
	 * ���@���F�@�����̏������ꂼ��ێ�����B
	 */
	public PostDTO(int id, String postName, int bossid) {
		this.id = id;
		this.postName = postName;
		this.bossid = bossid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public int getBossid() {
		return bossid;
	}
	public void setBossid(int bossid) {
		this.bossid = bossid;
	}
}