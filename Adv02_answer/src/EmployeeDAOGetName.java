import dao.EmployeeDAO;


// EmployeeDAO�𗘗p���Aemployee�e�[�u���ɃA�N�Z�X����v���O����
public class EmployeeDAOGetName {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();

		String result = dao.getName(100);
		if (result == null) {
        	System.out.println("�w�肳�ꂽID��������܂���B");
		} else {
			System.out.println("ID100�̎�����" + result + "�ł��B");
		}
	}
}