class ImplementBase1 extends Base1 implements InterfaceBase1 {
	// このクラスでは掛け算を実行する
	public int calculate(int target) {
		return target * value;
	}
	// 計算を実行して結果を表示する
	public void printResult(int target) {
		System.out.println("計算結果は" + calculate(target) + "です");
	}
}