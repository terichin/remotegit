import dao.*;
import dto.*;

// EmployeeInfoDAO����DTO�Ńf�[�^���擾����v���O����
public class EmployeeInfoDAOGetEmployeeInfo {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			EmployeeInfoDAO dao = new EmployeeInfoDAO();
			EmployeeInfoDTO dto = dao.getEmployeeInfo(id);
			if (dto == null) {
	        	System.out.println("�w�肳�ꂽID��������܂���B");
			} else {
				System.out.println("ID" + dto.getId() + 
					"�̎�����" + dto.getUserName() +
					"�A�p�X���[�h��" + dto.getPassword() +
					"�A�����ԍ���" + dto.getExtension() + 
					"�A�g�єԍ���" + dto.getMobile() + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		} catch (NumberFormatException e) {
			System.out.println("ID�ɂ͐�������͂��Ă��������B");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�����̎w�肪�Ԉ���Ă��܂��B");
		}
	}
}