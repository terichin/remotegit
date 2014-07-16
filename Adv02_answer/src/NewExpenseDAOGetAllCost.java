import java.util.*;

import dao.*;

// NewExpenseDAOクラスを使用し、expenseテーブルのデータの
// 参照を実行するプログラム
public class NewExpenseDAOGetAllCost {
	// NewExpenseDAOクラスの各メソッドを呼び出して実行するmain()メソッド
	public static void main(String[] args) {
		try {
			NewExpenseDAO dao = new NewExpenseDAO();

			int id = Integer.parseInt(args[0]);

			// expenseテーブルからコストのリストを取得する
			ArrayList<Integer> list = dao.getAllCost(id);
			if (list != null) {
				System.out.println("ID" + id +
					"のコストリストの内容を表示します。");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			} else {
				System.out.println("当該IDのコストはありません。");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("与えられたデータ項目の数が足りません。");
		} catch (NumberFormatException e) {
			System.out.println("IDは数値でなければなりません。");
		} catch (DAOException e) {
        	System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}