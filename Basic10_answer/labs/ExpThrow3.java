import java.io.*;
class ExpThrow3 {
	public static void main(String[] args) {
		try {
			int number = inputNumber();
			System.out.println("入力値は" + number);
		} catch (MyException e) {
			System.out.println("入力でエラーが発生しました。");
		}
	}
	// ライン入力を行い、整数を受け取るメソッド
	public static int inputNumber() throws MyException {
		int number = 0;
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("数値を入力して下さい：");
			String s = brd.readLine();
			number = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new MyException();
		} catch (IOException e) {
			throw new MyException();
		}
		return number;
	}
}