import univelec.dao.*;
import univelec.dto.*;

public class UserDAOAdd {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO("NTT�ܘY", "NTT���낤", "03-9999-8765", "goro@example.com", "test", 0);
			int result = dao.add(dto);
			if (result == 1) { 
				System.out.println("�ǉ��ɐ������܂����B");
			} else {
				System.out.println("�ǉ��Ɏ��s���܂����B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
