import dao.NewContactDAO;
import dto.ContactDTO;
import dao.DAOException;

// NewContactDAO����DTO�Ńf�[�^���擾����v���O����
public class NewContactDAOGetContact {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			NewContactDAO dao = new NewContactDAO();
			ContactDTO dto = dao.getContact(id);
			if (dto == null) {
	        	System.out.println("�w�肳�ꂽID��������܂���B");
			} else {
				System.out.println("ID" + dto.getId() + "�̓����ԍ���" +
					dto.getExtension() + "�A�g�єԍ���" +
					dto.getMobile() + "�ł��B");
			}
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		} catch (NumberFormatException e) {
			System.out.println("ID�͐����Ŏw�肵�ĉ������B");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�����̎w�肪�Ԉ���Ă��܂��B");
		}
	}
}
