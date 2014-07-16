import dao.NewEmployeeDAO;
import dao.DAOException;

// EmployeeDAOクラスを利用し、employeeテーブルにアクセスするプログラム
public class NewEmployeeDAOGetName {
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			String result = dao.getName(100);
			if (result == null) {
	        	System.out.println("指定されたIDが見つかりません。");
			} else {
				System.out.println("ID100の氏名は" + result + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
	
}