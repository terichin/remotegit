import dao.PostDAO;

// PostDAO�N���X���g�p���Apost�e�[�u���̃f�[�^��
// �Q�Ƃ����s����v���O����
public class PostDAOGetName {
    // PostDAO�N���X��getName()���\�b�h���Ăяo���Ď��s����main()���\�b�h
    public static void main(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);

            PostDAO dao = new PostDAO();
            String result = dao.getName(id);
            if (result == null) {
                System.out.println("�w�肳�ꂽID��������܂���B");
            } else {
                System.out.println("ID" + id + "�̕�������" + result + "�ł��B");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�^����ꂽ�f�[�^���ڂ̐�������܂���B");
        } catch (NumberFormatException e) {
            System.out.println("ID�͐��l�łȂ���΂Ȃ�܂���B");
        }
    }
}