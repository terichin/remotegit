class InterfaceUser1 {
	public static void main(String[] args) {
		// インタフェースを実現したクラスのオブジェクトを2つ生成
		ImplementBase1 obj1 = new ImplementBase1();
		ImplementBase2 obj2 = new ImplementBase2();

		// 生成したオブジェクトのprintResult()メソッドを実行
		obj1.printResult(10);
		obj2.printResult(10);
	}
}