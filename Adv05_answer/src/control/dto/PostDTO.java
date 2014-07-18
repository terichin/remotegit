package control.dto;

//部署情報を保存するクラス
public class PostDTO {
	private int id;			// ユーザコード
	private String postName;	// 部署名
	private int bossid;		// 上司ID
	/*
	 * 機　能：　コンストラクタ。
	 *
	 * 引　数：　ユーザコード、部署名、上司ID。
	 * 解　説：　引数の情報をそれぞれ保持する。
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