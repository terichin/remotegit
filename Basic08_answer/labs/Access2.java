class Access2 {
	// 非公開のメンバ変数num1
	private int num1 = 222;
	// 公開されるメンバ変数num2
	public int num2 = 500;

	// 非公開のメンバメソッドprivatePrint
	private void privatePrint() {
		// メンバ変数num1の値を表示
		System.out.println(num1);
		// メンバ変数num2の値を表示
		System.out.println(num2);
	}

	// 公開されるメンバメソッドprint
	public void print() {
		// メンバメソッドprivatePrintの呼び出し
		privatePrint();
	}
}