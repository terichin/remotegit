import java.util.*;
import dao.*;
import dto.*;

// EmployeeDAOからDTOでデータを取得するプログラム
public class NewEmployeeDAOGetAllEmployee {
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			ArrayList<EmployeeDTO> list = dao.getAllEmployee();
			for(int i = 0; i < list.size(); i++) {
				EmployeeDTO dto = list.get(i);
				System.out.println("ID" + dto.getId() + "の氏名は" + dto.getName() + 
						"、パスワードは" + dto.getPassword() + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}