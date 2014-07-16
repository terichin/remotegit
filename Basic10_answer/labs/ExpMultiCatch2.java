import java.io.*;
class ExpMultiCatch2 {
	public static void main(String[] args) {
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("数値を入力して下さい：");
			String s = brd.readLine();
			int number = Integer.parseInt(s);
			System.out.println("入力された値は" + number);
		} catch (NumberFormatException e) {
			System.out.println("数値は整数で入力しなければいけません。");
		} catch (IOException e) {
			System.out.println("入力に問題が発生しました。");
		}
	}
}