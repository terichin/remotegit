class Accessor2 {
	// 非公開のメンバ変数name
	private String name;

	// メンバ変数nameの値を返すアクセッサメソッド
	public String getName() {
		return name;
	}

	// メンバ変数nameに値を設定するアクセッサメソッド
	public void setName(String name) {
		this.name = name;
	}
}