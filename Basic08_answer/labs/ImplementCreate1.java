class ImplementCreate1 {
	public static void main(String[] args) {
		// ImplementObject1 クラスのインスタンスを生成して
		// ImplementObject1型の変数 obj1 に代入する。
		ImplementObject1 obj = new ImplementObject1();
		// obj の calculate()メソッドを実行する。
		// 引数は100とする。実行結果を表示する。
		System.out.println(obj.calculate(100));
		// obj の printRate()メソッドを実行する。
		obj.printRate();
	}
}