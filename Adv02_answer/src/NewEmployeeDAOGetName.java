import dao.NewEmployeeDAO;
import dao.DAOException;

// EmployeeDAO�N���X�𗘗p���Aemployee�e�[�u���ɃA�N�Z�X����v���O����
public class NewEmployeeDAOGetName {
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			String result = dao.getName(100);
			if (result == null) {
	        	System.out.println("�w�肳�ꂽID��������܂���B");
			} else {
				System.out.println("ID100�̎�����" + result + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
	
}