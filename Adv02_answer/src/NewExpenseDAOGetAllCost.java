import java.util.*;

import dao.*;

// NewExpenseDAO�N���X���g�p���Aexpense�e�[�u���̃f�[�^��
// �Q�Ƃ����s����v���O����
public class NewExpenseDAOGetAllCost {
	// NewExpenseDAO�N���X�̊e���\�b�h���Ăяo���Ď��s����main()���\�b�h
	public static void main(String[] args) {
		try {
			NewExpenseDAO dao = new NewExpenseDAO();

			int id = Integer.parseInt(args[0]);

			// expense�e�[�u������R�X�g�̃��X�g���擾����
			ArrayList<Integer> list = dao.getAllCost(id);
			if (list != null) {
				System.out.println("ID" + id +
					"�̃R�X�g���X�g�̓��e��\�����܂��B");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
			} else {
				System.out.println("���YID�̃R�X�g�͂���܂���B");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�^����ꂽ�f�[�^���ڂ̐�������܂���B");
		} catch (NumberFormatException e) {
			System.out.println("ID�͐��l�łȂ���΂Ȃ�܂���B");
		} catch (DAOException e) {
        	System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
		}
	}
}