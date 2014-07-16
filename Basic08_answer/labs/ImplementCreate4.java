class ImplementCreate4 {
	public static void main(String[] args) {
		// ImplementObject1 クラスのインスタンスを生成して
		// InterfaceObject1型の変数 obj1 に代入する。
		InterfaceObject1 obj1 = new ImplementObject1();
		// ImplementObject2 クラスのインスタンスを生成して
		// InterfaceObject1型の変数 obj2 に代入する。
		InterfaceObject1 obj2 = new ImplementObject2();
		// InterfaceUtility2のcalculate()メソッドを実行。
		// 引数は obj1 と 100 とする。実行結果を表示する。
		System.out.println(InterfaceUtility2.calculate(obj1, 100));
		// InterfaceUtility2のcalculate()メソッドを実行。
		// 引数は obj2 と 100 とする。実行結果を表示する。
		System.out.println(InterfaceUtility2.calculate(obj2, 100));
	}
}