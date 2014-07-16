import java.util.*;
import dao.*;
// employee�Acontact�Apost�Aexpense�̊e�e�[�u������w��̏]�ƈ��̏����擾����v���O����
public class FindUserInfo2 {
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			// �]�ƈ����擾
			EmployeeDAO empDao = new EmployeeDAO();
			String name = empDao.getName(id);
			
			// �����ԍ��擾
			ContactDAO contactDao = new ContactDAO();
			int extension = contactDao.getExtension(id);
			
			// �������擾
			NewPostDAO postDao = new NewPostDAO();
			String postName = postDao.getName(id);
			
			// �R�X�g���X�g�擾
			NewExpenseDAO expenseDao = new NewExpenseDAO();
			ArrayList<Integer> list = expenseDao.getAllCost(id);
			
			System.out.println("ID" + id +
				"�̎�����" + name +"�A�����ԍ���" + extension + 
				"�A��������" + postName + "�ł��B");
			
			System.out.println("ID" + id + "�̔�p���X�g�̓��e��\�����܂��B");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("��������ID�������ŗ^����K�v������܂��B");
		} catch (NumberFormatException e) {
			System.out.println("��������ID�͐��l�łȂ���΂Ȃ�܂���B");
		} catch (DAOException e) {
			System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}