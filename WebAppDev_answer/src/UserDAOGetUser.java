import univelec.dao.*;
import univelec.dto.*;

public class UserDAOGetUser {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			UserDTO dto = dao.getUser(4);
			System.out.println("番号\t氏名\t\tかな\t電話番号\tメールアドレス\t\tユーザ権限");
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
