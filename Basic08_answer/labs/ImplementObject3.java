public class ImplementObject3 implements InterfaceObject3 {
	// int型の値を格納するための配列
	int[] numbers = null;

	// コマンドライン引数の配列を作成するメソッド
	public boolean changeArgsToNumbers(String[] args) {
		// もし配列が空であればfalseを返す
		if (args.length == 0) {
			return false;
		}
		// 配列の領域を作成
		numbers = new int[args.length];
		// 整数への変換
		for (int i = 0; i < args.length; i++) {
			numbers[i] = Integer.parseInt(args[i]);
		}
		return true;
	}
	// バブルソートメソッド
	public void sortNumbers() {
		boolean loop = true; // ループ制御用変数
		while (loop) {
			loop = false; // 次回ループをしないようセット
			// 以下は一回の巡回を行うためのループ
			// 要素数の一つ手前までループする
			for (int i = 0; i < numbers.length - 1; i++) {
				// 大小関係が逆なら入れ替え
				if (numbers[i] > numbers[i + 1]) {
					int number = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = number;
					loop = true; // 入れ替えがあったので次回はループする
				}
			}
		}
	}
	// 値を表示するメソッド
	public void printNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 自クラスのインスタンスを生成して実行
		InterfaceObject3 obj = new ImplementObject3();
		if (obj.changeArgsToNumbers(args) == false) {
			System.out.println("整数の値をいくつか入れて下さい。");
		} else {
			obj.sortNumbers();
			obj.printNumbers();
		}
	}
}