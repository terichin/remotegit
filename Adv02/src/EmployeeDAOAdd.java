import dao.EmployeeDAO;

// EmployeeDAOを利用し、employeeテーブルにアクセスするプログラム
public class EmployeeDAOAdd {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();

		int id = 201;
		String name = "データ一郎";
		String password = "data16";

		int count = dao.add(id, name, password);
		if (count != 1) {
			System.out.println("データの挿入に失敗しました。");
		} else {
			System.out.println(count + "行追加しました。");
		}
	}
}