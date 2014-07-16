class AccessUser1 {
	public static void main(String[] args) {
		// Access1クラスのオブジェクトを生成
		Access1 obj = new Access1();
		// 生成したオブジェクトのpublicメンバ変数number2の値を表示
		System.out.println(obj.number2);
		// 生成したオブジェクトのpublicメンバメソッドprintの呼び出し
		obj.print();
	}
}