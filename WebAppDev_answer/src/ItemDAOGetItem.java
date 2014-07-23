import univelec.dao.*;
import univelec.dto.*;

public class ItemDAOGetItem {
	public static void main(String[] args) {
		try {
			ItemDAO dao = new ItemDAO();
			ItemDTO dto = dao.getItem(2);
			if (dto != null) {
				System.out.println("�ԍ�\t���i��\t\t���i");
				System.out.print(dto.getNo() + "\t");
				System.out.print(dto.getName() + "\t");
				System.out.println(dto.getPrice());
			} else {
				System.out.println("���i���̎擾�Ɏ��s���܂����B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
