import java.util.*;
import univelec.dao.*;
import univelec.dto.*;

public class UserDAOGetUserList {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			ArrayList<UserDTO> list = dao.getUserList();
			System.out.println("�ԍ�\t����\t\t�d�b�ԍ�\t���[���A�h���X\t\t���[�U����");
			for (int i = 0; i < list.size(); i++) {
				UserDTO dto = list.get(i);
				System.out.print(dto.getId() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.print(dto.getPhone() + "\t");
				System.out.print(dto.getMail() + "\t");
				System.out.println(dto.getPrivilege() + "\t");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
