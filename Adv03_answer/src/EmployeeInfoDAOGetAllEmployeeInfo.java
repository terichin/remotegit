import java.util.*;
import dao.*;
import dto.*;

// EmployeeInfoDAOからDTOでデータを取得するプログラム
public class EmployeeInfoDAOGetAllEmployeeInfo {
	public static void main(String[] args) {
		try {
			EmployeeInfoDAO dao = new EmployeeInfoDAO();
			ArrayList<EmployeeInfoDTO> list = dao.getAllEmployeeInfo();
			for (int i = 0; i < list.size(); i++) {
				EmployeeInfoDTO dto = list.get(i);
				System.out.println("ID" + dto.getId() + 
						"の氏名は" + dto.getUserName() +
						"、パスワードは" + dto.getPassword() +
						"、内線番号は" + dto.getExtension() + 
						"、携帯番号は" + dto.getMobile() + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		}
	}
}