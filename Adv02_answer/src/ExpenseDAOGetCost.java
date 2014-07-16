import java.text.*;
import dao.*;

// ExpenseDAOクラスを使用し、expenseテーブルのデータの
// 参照を実行するプログラム
public class ExpenseDAOGetCost {
    // ExpenseDAOクラスの各メソッドを呼び出して実行するmain()メソッド
    public static void main(String[] args) {
        try {
            ExpenseDAO dao = new ExpenseDAO();

            int id = Integer.parseInt(args[0]);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(args[1]);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            // expenseテーブルからコストを取得する
            int cost = dao.getCost(id, sqlDate);
            System.out.println("合計金額は" + cost + "円です。");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("与えられたデータ項目の数が足りません。");
        } catch (NumberFormatException e) {
            System.out.println("IDは数値でなければなりません。");
        } catch (ParseException e) {
            System.out.println("日付形式が正しくありません。");
        }
    }
}