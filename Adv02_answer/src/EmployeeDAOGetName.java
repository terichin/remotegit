import dao.EmployeeDAO;


// EmployeeDAOを利用し、employeeテーブルにアクセスするプログラム
public class EmployeeDAOGetName {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();

		String result = dao.getName(100);
		if (result == null) {
        	System.out.println("指定されたIDが見つかりません。");
		} else {
			System.out.println("ID100の氏名は" + result + "です。");
		}
	}
}