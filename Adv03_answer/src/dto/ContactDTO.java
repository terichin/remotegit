package dto;

public class ContactDTO {
	private int id;
	private int extension;
	private String mobile;
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