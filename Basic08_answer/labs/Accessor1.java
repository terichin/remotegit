class Accessor1 {
	// 非公開のメンバ変数value
	private int value = 0;

	// メンバ変数valueの値を返すアクセッサメソッド
	public int getValue() {
		return value;
	}

	// メンバ変数valueに値を設定するアクセッサメソッド
	public void setValue(int value) {
		this.value = value;
	}
}