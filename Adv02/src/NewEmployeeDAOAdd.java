import dao.DAOException;
import dao.NewEmployeeDAO;

// EmployeeDAOクラスを使用し、employeeテーブルのデータの
// 挿入を実行するプログラム
public class NewEmployeeDAOAdd {
	// EmployeeDAOクラスの各メソッドを呼び出して実行するmainメソッド
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			int id = 202;
			String name = "NTT三郎";
			String password = "ntt36";
			int count = dao.add(id, name, password);
			if (count != 1) {
				System.out.println("データの挿入に失敗しました。");
			} else {
				System.out.println(count + "行追加しました。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
	
}