class ImplementObject2 implements InterfaceObject1 {
	// rate1変数は double 型で0.20で初期化するよう定義する。
	double rate1 = 0.20;

	// rate2変数は double 型で0.60で初期化するよう定義する。
	double rate2 = 0.60;

	// getRate()メソッドは doubleと定義する。
	public double getRate() {
		// multiplyRate() と plusRate() の実行結果を足した値を返す。
		return multiplyRate() + plusRate();
	}
	// multiplyRate()メソッドは doubleと定義する。
	double multiplyRate() {
		// rate1 と rate2 掛けた値を返す。
		return rate1 * rate2;
	}
	// plusRate()メソッドは double と定義する。
	double plusRate() {
		// rate1 と rate2 足した値を返す。
		return rate1 + rate2;
	}
	// calculate()メソッドは、double と宣言し、
	// int型引数valueを受け取るよう定義する
	public double calculate(int value) {
		// value と getRate() の乗算結果を返す。
		return value * getRate();
	}
	public static void main(String[] args) {
		// ImplementObject2 クラスのインスタンスを生成して
		// ImplementObject2型の変数 obj に代入する。
		ImplementObject2 obj = new ImplementObject2();
		// obj の calculate()メソッドを実行する。
		// 引数は100とする。実行結果を表示する。
		System.out.println(obj.calculate(100));
		// obj の plusRate()メソッドの実行結果を表示する。
		System.out.println(obj.plusRate());
		// obj の multiplyRate()メソッドの実行結果を表示する。
		System.out.println(obj.multiplyRate());
	}
}