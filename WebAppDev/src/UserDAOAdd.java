import univelec.dao.*;
import univelec.dto.*;

public class UserDAOAdd {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO("NTT五郎", "NTTごろう", "03-9999-8765", "goro@example.com", "test", 0);
			int result = dao.add(dto);
			if (result == 1) { 
				System.out.println("追加に成功しました。");
			} else {
				System.out.println("追加に失敗しました。");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
