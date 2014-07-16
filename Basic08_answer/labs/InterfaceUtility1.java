class InterfaceUtility1 {
	// printCalcメソッドは、
	// 渡されたオブジェクトのcalculate()メソッドの結果を表示する
	static void printCalc(ImplementObject1 obj, int value) {
		// objのcalculate()メソッドの結果を表示する
		System.out.println(obj.calculate(value));
	}
	// printRate()メソッドは、渡されたオブジェクトのgetRate()メソッドの結果を表示する
	static void printRate(ImplementObject2 obj) {
		// objのメンバ変数rateの値を取得、表示する
		System.out.println(obj.getRate());
	}
}