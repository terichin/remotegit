import dao.DAOException;
import dao.NewEmployeeDAO;

// EmployeeDAO�N���X���g�p���Aemployee�e�[�u���̃f�[�^��
// �}�������s����v���O����
public class NewEmployeeDAOAdd {
	// EmployeeDAO�N���X�̊e���\�b�h���Ăяo���Ď��s����main���\�b�h
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			int id = 202;
			String name = "NTT�O�Y";
			String password = "ntt36";
			int count = dao.add(id, name, password);
			if (count != 1) {
				System.out.println("�f�[�^�̑}���Ɏ��s���܂����B");
			} else {
				System.out.println(count + "�s�ǉ����܂����B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
	
}