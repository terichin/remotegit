import java.util.*;
import dao.*;
import dto.*;

// EmployeeDAO����DTO�Ńf�[�^���擾����v���O����
public class NewEmployeeDAOGetAllEmployee {
	public static void main(String[] args) {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			ArrayList<EmployeeDTO> list = dao.getAllEmployee();
			for(int i = 0; i < list.size(); i++) {
				EmployeeDTO dto = list.get(i);
				System.out.println("ID" + dto.getId() + "�̎�����" + dto.getName() + 
						"�A�p�X���[�h��" + dto.getPassword() + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}