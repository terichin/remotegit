package dto;

public class EmployeeInfoDTO {
	private int id;
	private String password;
	private String userName;
	private int extension;
	private String mobile;
	public EmployeeInfoDTO(int id, String password,
		String userName, int extension, String mobile) {
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.extension = extension;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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