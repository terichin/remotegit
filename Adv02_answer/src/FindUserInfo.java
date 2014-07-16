import dao.*;
// employee�e�[�u����contact�e�[�u������w��̏]�ƈ��̏����擾����v���O����
public class FindUserInfo {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			// �]�ƈ����擾
			EmployeeDAO empDao = new EmployeeDAO();
			String name = empDao.getName(id);
			
			// �����ԍ��擾
			ContactDAO contactDao = new ContactDAO();
			int extension = contactDao.getExtension(id);
			
			System.out.println("ID" + id + "�̎�����" + name +
				"�A�����ԍ���" + extension + "�ł��B");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("��������ID�������ŗ^����K�v������܂��B");
		} catch (NumberFormatException e) {
			System.out.println("��������ID�͐��l�łȂ���΂Ȃ�܂���B");
		}
	}
}