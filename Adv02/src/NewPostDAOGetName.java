import dao.NewPostDAO;
import dao.DAOException;

// NewPostDAO�N���X���g�p���Apost�e�[�u���̃f�[�^��
// �Q�Ƃ����s����v���O����
public class NewPostDAOGetName {
    // NewPostDAO�N���X�̊e���\�b�h���Ăяo���Ď��s����main()���\�b�h
    public static void main(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);

            NewPostDAO dao = new NewPostDAO();
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
        } catch (DAOException e) {
            System.out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
        }
    }
}