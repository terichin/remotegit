import dao.ContactDAO;

// ContactDAO�N���X�𗘗p���Acontact�e�[�u���ɃA�N�Z�X����v���O����
public class ContactDAOGetExtension {
	public static void main(String[] args) {
		ContactDAO dao = new ContactDAO();
		int extension = dao.getExtension(100);
		if (extension == -1) {
        	System.out.println("�w�肳�ꂽID��������܂���B");
		} else {
			System.out.println("ID100�̓����ԍ���" + extension + "�ł��B");
		}
	}
}