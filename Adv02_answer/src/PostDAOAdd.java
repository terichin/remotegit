import dao.*;

// PostDAO�N���X���g�p���Apost�e�[�u���̃f�[�^��
// �ǉ������s����v���O����
public class PostDAOAdd {
	// PostDAO�N���X��add()���\�b�h���Ăяo���Ď��s����main()���\�b�h
	public static void main(String[] args) {
		try {
			int id = Integer.parseInt(args[0]);
			String postname = args[1];
			int bossid = Integer.parseInt(args[2]);
			PostDAO dao = new PostDAO();
			int result = dao.add(id, postname, bossid);
			
			if (result == 1) {
	        	System.out.println("�ǉ��ɐ������܂���");
			} else {
				System.out.println("�ǉ��Ɏ��s���܂���");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�ǉ�����f�[�^�������œn���K�v������܂��B");
		} catch (NumberFormatException e) {
			System.out.println("ID�Ə㒷ID�͐����œn���K�v������܂��B");
		}
	}
}