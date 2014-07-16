import java.text.*;
import dao.*;

// ExpenseDAO�N���X���g�p���Aexpense�e�[�u���̃f�[�^��
// �Q�Ƃ����s����v���O����
public class ExpenseDAOGetCost {
    // ExpenseDAO�N���X�̊e���\�b�h���Ăяo���Ď��s����main()���\�b�h
    public static void main(String[] args) {
        try {
            ExpenseDAO dao = new ExpenseDAO();

            int id = Integer.parseInt(args[0]);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(args[1]);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            // expense�e�[�u������R�X�g���擾����
            int cost = dao.getCost(id, sqlDate);
            System.out.println("���v���z��" + cost + "�~�ł��B");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�^����ꂽ�f�[�^���ڂ̐�������܂���B");
        } catch (NumberFormatException e) {
            System.out.println("ID�͐��l�łȂ���΂Ȃ�܂���B");
        } catch (ParseException e) {
            System.out.println("���t�`��������������܂���B");
        }
    }
}