import dao.EmployeeDAO;

// EmployeeDAO�𗘗p���Aemployee�e�[�u���ɃA�N�Z�X����v���O����
public class EmployeeDAOAdd {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();

		int id = 201;
		String name = "�f�[�^��Y";
		String password = "data16";

		int count = dao.add(id, name, password);
		if (count != 1) {
			System.out.println("�f�[�^�̑}���Ɏ��s���܂����B");
		} else {
			System.out.println(count + "�s�ǉ����܂����B");
		}
	}
}