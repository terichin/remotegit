import univelec.dao.*;
import univelec.dto.*;

public class UserDAOEdit {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO(4, "���l�q", "03-1111-2222", "4ko@example.com");
			int result = dao.edit(dto);
			if (result == 1) { 
				System.out.println("�X�V�ɐ������܂����B");
			} else {
				System.out.println("�X�V�Ɏ��s���܂����B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
