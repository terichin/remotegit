import dao.*;

// TableJoinDAO�N���X���g�p���A�l�X�ȃe�[�u���̃f�[�^��
// �Q�Ƃ����s����v���O����
public class TableJoinDAOFindEmployee {
    // TableJoinDAO�N���X��findEmployee()���\�b�h���Ăяo���Ď��s����main()���\�b�h
    public static void main(String[] args) {
        try {
            TableJoinDAO dao = new TableJoinDAO();
            int id = Integer.parseInt(args[0]);

            String[] empInfo = dao.findEmployee(id);
            if (empInfo != null) {
                System.out.println("�]�ƈ�ID" + id + "�̏����ȉ��ɕ\�����܂�");
                System.out.println("�]�ƈ���: " + empInfo[0]);
                System.out.println("�����ԍ�: " + empInfo[1]);
                System.out.println("�g�єԍ�: " + empInfo[2]);
                System.out.println("����������: " + empInfo[3]);
                System.out.println("��i����: " + empInfo[4]);
            } else {
                System.out.println("ID" + id + "�̏��͂���܂���B");
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