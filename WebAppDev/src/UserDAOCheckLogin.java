import univelec.dao.*;
import univelec.dto.*;

public class UserDAOCheckLogin {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO(1, "pass01");
			boolean result = dao.checkLogin(dto);
			if (result == true) { 
				System.out.println("ログインに成功しました。");
			} else {
				System.out.println("ログインに失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
