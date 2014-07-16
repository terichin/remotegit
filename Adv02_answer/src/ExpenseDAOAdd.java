import dao.ExpenseDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// ExpenseDAO�N���X���g�p���Aexpense�e�[�u���̃f�[�^��
// �ǉ������s����v���O����
public class ExpenseDAOAdd {
    // ExpenseDAO�N���X�̊e���\�b�h���Ăяo���Ď��s����main()���\�b�h
    public static void main(String[] args) {
        try {
            ExpenseDAO dao = new ExpenseDAO();

            int exid = Integer.parseInt(args[0]);
            int id = Integer.parseInt(args[1]);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(args[2]);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String use = args[3];
            int cost = Integer.parseInt(args[4]);

            // �R�}���h���C�������Ŏ󂯎�����f�[�^��expense�e�[�u���ɒǉ�����
            int count = dao.add(exid, id, sqlDate, use, cost);
            if (count != 1) {
                System.out.println("�f�[�^�̑}���Ɏ��s���܂����B");
            } else {
                System.out.println(count + "�s�ǉ����܂����B");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("�^����ꂽ�f�[�^���ڂ̐�������܂���B");
        } catch (NumberFormatException e) {
            System.out.println("�o��ID�AID�A��p�͐��l�łȂ���΂Ȃ�܂���B");
        } catch (ParseException e) {
            System.out.println("���t�`��������������܂���B");
        }
    }
}