import dao.*;
import dto.*;

// NewEmployeeDAO����DTO�Ńf�[�^���擾����v���O����
public class NewEmployeeDAOGetEmployee {
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			EmployeeDTO dto = dao.getEmployee(100);
			if (dto == null) {
	        	System.out.println("�w�肳�ꂽID��������܂���B");
			} else {
				System.out.println("ID" + dto.getId() + "�̎�����" + dto.getName() + 
					"�A�p�X���[�h��" + dto.getPassword() + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}