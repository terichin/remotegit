import univelec.dao.*;

public class UserDAODelete {
	public static void main(String[] args) {
		try {
			UserDAO dao = new UserDAO();
			// �K���ȃ��[�U��o�^���Ă���폜�����s���Ă�������
			int result = dao.delete(5);
			if (result == 1) { 
				System.out.println("�폜�ɐ������܂����B");
			} else {
				System.out.println("�폜�Ɏ��s���܂����B");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
