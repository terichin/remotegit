import univelec.dao.*;
import univelec.dto.*;

public class UserDAOGetUser {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = dao.getUser(4);
			System.out.println("�ԍ�\t����\t\t����\t�d�b�ԍ�\t���[���A�h���X\t\t���[�U����");
			System.out.print(dto.getId() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getKana() + "\t");
			System.out.print(dto.getPhone() + "\t");
			System.out.print(dto.getMail() + "\t");
			System.out.println(dto.getPrivilege() + "\t");
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
