class AccessorUser1 {
	public static void main(String[] args) {
		// Accessor1クラスのインスタンスを生成
		Accessor1 obj = new Accessor1();
		// 生成したオブジェクトのメンバ変数に値を設定する
		obj.setValue(9900);
		// オブジェクトのメンバ変数の値を取得する
		int num = obj.getValue();
		// 取得した値を表示する
		System.out.println(num);
	}
}