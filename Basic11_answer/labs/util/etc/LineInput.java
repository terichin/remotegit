// このクラスは以下のパッケージに属します
package util.etc;
// 入出力とユーザ定義例外のためのインポート宣言が必要です。
import java.io.*;
import util.exception.*;
public class LineInput {
	// 数値を入力するメソッド
	public int inputNumber() throws UserException {
		int number = 0;
		try {
			InputStreamReader srd = new InputStreamReader(System.in);
			BufferedReader brd = new BufferedReader(srd);
			System.out.print("数値を入力して下さい：");
			String s = brd.readLine();
			number = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new UserException();
		} catch (IOException e) {
			throw new UserException();
		}
		return number;
	}
}