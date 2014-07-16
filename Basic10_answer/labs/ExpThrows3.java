import java.io.*;
class ExpThrows3 {
	public static void main(String[] args) {
		try {
			int number = inputNumber();
			int rnumber = (int)(Math.random() * 2.0);
			System.out.println("入力値は" + number);
			System.out.println("乱数値は" + rnumber);
			System.out.println("計算値は" + number / rnumber);
		} catch (NumberFormatException e) {
			System.out.println("数値は整数で入力しなければいけません。");
		} catch (ArithmeticException e) {
			System.out.println("計算でエラーが発生しました。");
		}
	}
	// ライン入力を行い、整数を受け取るメソッド
	public static int inputNumber() throws NumberFormatException {
		int number = 0;
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("数値を入力して下さい：");
			String s = brd.readLine();
			number = Integer.parseInt(s);
		} catch (IOException e) {
			System.out.println("入力に問題が発生しました。");
			System.exit(0);
		}
		return number;
	}
}