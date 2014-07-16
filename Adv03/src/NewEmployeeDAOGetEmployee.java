import dao.*;
import dto.*;

// NewEmployeeDAOからDTOでデータを取得するプログラム
public class NewEmployeeDAOGetEmployee {
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			EmployeeDTO dto = dao.getEmployee(100);
			if (dto == null) {
	        	System.out.println("指定されたIDが見つかりません。");
			} else {
				System.out.println("ID" + dto.getId() + "の氏名は" + dto.getName() + 
					"、パスワードは" + dto.getPassword() + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}