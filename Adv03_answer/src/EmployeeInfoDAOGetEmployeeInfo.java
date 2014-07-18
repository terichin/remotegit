import dao.*;
import dto.*;

// EmployeeInfoDAOからDTOでデータを取得するプログラム
public class EmployeeInfoDAOGetEmployeeInfo {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			EmployeeInfoDAO dao = new EmployeeInfoDAO();
			EmployeeInfoDTO dto = dao.getEmployeeInfo(id);
			if (dto == null) {
	        	System.out.println("指定されたIDが見つかりません。");
			} else {
				System.out.println("ID" + dto.getId() + 
					"の氏名は" + dto.getUserName() +
					"、パスワードは" + dto.getPassword() +
					"、内線番号は" + dto.getExtension() + 
					"、携帯番号は" + dto.getMobile() + "です。");
			}
		} catch (DAOException e) {
			System.out.println("DBアクセスでエラーが発生しました。");
		} catch (NumberFormatException e) {
			System.out.println("IDには整数を入力してください。");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("引数の指定が間違っています。");
		}
	}
}