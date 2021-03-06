import dao.NewExpenseDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// NewExpenseDAOクラスを使用し、expenseテーブルのデータの
// 追加を実行するプログラム
public class NewExpenseDAOAdd {
	// NewExpenseDAOクラスのadd()メソッドを呼び出して実行するmainメソッド
	public static void main(String[] args) {
		try {
			NewExpenseDAO dao = new NewExpenseDAO();

			int exid = Integer.parseInt(args[0]);
			int id = Integer.parseInt(args[1]);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(args[2]);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String use = args[3];
			int cost = Integer.parseInt(args[4]);

			// コマンドライン引数で受け取ったデータをexpenseテーブルに追加する
			int count = dao.add(exid, id, sqlDate, use, cost);
			if (count != 1) {
				System.out.println("データの挿入に失敗しました。");
			} else {
				System.out.println(count + "行追加しました。");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("与えられたデータ項目の数が足りません。");
		} catch (NumberFormatException e) {
			System.out.println("経費ID、ID、費用は数値でなければなりません。");
		} catch (ParseException e) {
			System.out.println("日付形式が正しくありません。");
		} catch (DAOException e) {
        	System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}