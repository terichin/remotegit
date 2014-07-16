class Access1 {
	// 非公開のメンバ変数number1
	private double number1 = 123.45;
	// 公開されるメンバ変数number2
	public double number2 = 567.89;

	// 非公開のメンバメソッドmyMethod
	private void myMethod() {
		// メンバ変数number1の値を表示
		System.out.println(number1);
		// メンバ変数number2の値を表示
		System.out.println(number2);
	}

	// 公開されるメンバメソッドprint
	public void print() {
		System.out.println("オブジェクトは以下の値を持っています。");
		// myMethodメソッドの呼び出し
		myMethod();
	}
}