import dao.NewContactDAO;
import dto.ContactDTO;

import java.util.ArrayList;
import dao.DAOException;

// NewEmployeeDAO����DTO�Ńf�[�^���擾����v���O����
public class NewContactDAOGetAllContact {
	public static void main(String[] args) {
		try {
			NewContactDAO dao = new NewContactDAO();
			ArrayList<ContactDTO> list = dao.getAllContact();
			for(int i = 0; i < list.size(); i++) {
				ContactDTO dto = list.get(i);
				System.out.println("ID" + dto.getId() +
						"�̓����ԍ���" + dto.getExtension() + 
						"�A�g�єԍ���" + dto.getMobile() + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}