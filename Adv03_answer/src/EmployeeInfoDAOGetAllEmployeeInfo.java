import java.util.*;
import dao.*;
import dto.*;

// EmployeeInfoDAO����DTO�Ńf�[�^���擾����v���O����
public class EmployeeInfoDAOGetAllEmployeeInfo {
	public static void main(String[] args) {
		try {
			EmployeeInfoDAO dao = new EmployeeInfoDAO();
			ArrayList<EmployeeInfoDTO> list = dao.getAllEmployeeInfo();
			for (int i = 0; i < list.size(); i++) {
				EmployeeInfoDTO dto = list.get(i);
				System.out.println("ID" + dto.getId() + 
						"�̎�����" + dto.getUserName() +
						"�A�p�X���[�h��" + dto.getPassword() +
						"�A�����ԍ���" + dto.getExtension() + 
						"�A�g�єԍ���" + dto.getMobile() + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}