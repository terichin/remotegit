import univelec.dao.*;
import univelec.dto.*;

public class UserDAOEdit {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO(4, "駒場四子", "03-1111-2222", "4ko@example.com");
			int result = dao.edit(dto);
			if (result == 1) { 
				System.out.println("更新に成功しました。");
			} else {
				System.out.println("更新に失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
