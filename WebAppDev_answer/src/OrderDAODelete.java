import univelec.dao.*;

public class OrderDAODelete {
	public static void main(String[] args) {
		try {
			OrderDAO dao = new OrderDAO();
			int result = dao.delete(10);
			if (result == 1) {
				System.out.println("���������폜�ɐ������܂����B");
			} else {
				System.out.println("���������폜�Ɏ��s���܂����B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
