import dao.DAOException;
import dao.NewContactDAO;

// ContactDAO�N���X���g�p���ACONTACT�e�[�u���̃f�[�^��
// �ǉ��E�Q�Ƃ����s����v���O����
public class NewContactDAOGetExtension {	
	public static void main(String[] args) {
		try {
			NewContactDAO dao = new NewContactDAO();
			int extension = dao.getExtension(100);
			if (extension == -1) {
            	System.out.println("�w�肳�ꂽID��������܂���B");
			} else {
				System.out.println("ID100�̓����ԍ���" + extension + "�ł��B");
			}
		} catch (DAOException e) {
        	System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}