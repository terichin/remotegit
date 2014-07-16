import java.util.*;
import dao.*;
// employee、contact、post、expenseの各テーブルから指定の従業員の情報を取得するプログラム
public class FindUserInfo2 {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			// 従業員名取得
			EmployeeDAO empDao = new EmployeeDAO();
			String name = empDao.getName(id);
			
			// 内線番号取得
			ContactDAO contactDao = new ContactDAO();
			int extension = contactDao.getExtension(id);
			
			// 部署名取得
			NewPostDAO postDao = new NewPostDAO();
			String postName = postDao.getName(id);
			
			// コストリスト取得
			NewExpenseDAO expenseDao = new NewExpenseDAO();
			ArrayList<Integer> list = expenseDao.getAllCost(id);
			
			System.out.println("ID" + id +
				"の氏名は" + name +"、内線番号は" + extension + 
				"、部署名は" + postName + "です。");
			
			System.out.println("ID" + id + "の費用リストの内容を表示します。");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("検索するIDを引数で与える必要があります。");
		} catch (NumberFormatException e) {
			System.out.println("検索するIDは数値でなければなりません。");
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}