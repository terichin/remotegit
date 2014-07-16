// このクラスはパッケージに属していません
// ユーザ定義例外を使用するためにインポートが必要です
import util.etc.LineInput;
import util.exception.*;
public class PackageUser3 {
	public static void main(String[] args) {
		try {
			LineInput obj = new LineInput();
			int number = obj.inputNumber();
			System.out.println("入力値は" + number);
		} catch(UserException e) {
			System.out.println("入力エラーです。");
		}
	}
}