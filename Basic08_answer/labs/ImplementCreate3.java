class ImplementCreate3 {
	public static void main(String[] args) {
		// ImplementObject1 クラスのインスタンスを生成して
		// ImplementObject1型の変数 obj1 に代入する。
		ImplementObject1 obj1 = new ImplementObject1();
		// ImplementObject2 クラスのインスタンスを生成して
		// ImplementObject2型の変数 obj2 に代入する。
		ImplementObject2 obj2 = new ImplementObject2();
		// InterfaceUtility1のprintCalc()メソッドを実行。
		// 引数は obj1 ,100とする。実行結果を表示する。
		InterfaceUtility1.printCalc(obj1, 100);
		// InterfaceUtility1のprintRate()メソッドを実行。
		// 引数は obj2 とする。実行結果を表示する。
		InterfaceUtility1.printRate(obj2);
	}
}