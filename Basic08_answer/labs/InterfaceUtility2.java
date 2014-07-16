class InterfaceUtility2 {
	// calculate()メソッドは、static double と宣言し
	// InterfaceObject1型引数objとint型引数valueを受け取るよう定義する
	static double calculate(InterfaceObject1 obj, int value) {
		// obj の calculate()メソッドを実行。引数はvalueとする。実行結果を返す。
		return obj.calculate(value);
	}
}