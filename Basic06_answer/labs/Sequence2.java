class Sequence2 {
	// 変数の宣言
	int number1 = 0;
	int number2 = 0;
	// 値を設定するメソッド
	void setNumber1(int number) {
		number1 = number;
	}
	void setNumber2(int number) {
		number2 = number;
	}
	// 四則演算を行うメソッド
	void calc() {
		System.out.println("和は" + (number1 + number2));
		System.out.println("積は" + (number1 * number2));
		System.out.println("差は" + (number1 - number2));
		System.out.println("商は" + (number1 / number2));
	}
}