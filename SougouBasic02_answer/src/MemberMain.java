/*
 * �A�v���P�[�V�����̓���𐧌䂷��N���X�B
 */
public class MemberMain {

    //�Ј����̍��ږ�
    public static final String[] COLUMN_NAME = {
        "",
        "�Ј��R�[�h",
        "�Ј���",
        "����",
        "���i",
        "���Z",
        "�",
        "�o�g"
    };

    public static void main(String[] args) {
        while (true) {
            System.out.println("���[�h��I�����Ă�������");
            System.out.println();
            System.out.println("1 �Ј����o�^");
            System.out.println("2 �Ј���񌟍�");
            System.out.println("3 �I��");
            System.out.println();

            //�W�����͂��烂�[�h�ԍ����R���\�[������擾����
            String number = InputUtility.inputNumber(1, 3);

            System.out.println();

            //���͂��ꂽ���[�h�ԍ��ɉ����ď����𕪊򂷂�
            if (number.equals("1")) {
                Page10 page = new Page10();
                page.execute();
            } else if (number.equals("2")) {
                Page3 page = new Page3();
                page.execute();
            } else if (number.equals("3")) {
                System.exit(0);
            }
            System.out.println();
        }
    }

    public static String columnNameFormat(String str) {
        //�����̕����񐔂ƂT�����̍����擾
        int count = 5 - str.length();

        //�T�����ɂȂ�܂ň����ɋ󔒕�����ǉ�
        for (int i = 0; i < count; i++) {
            str += "�@";
        }

        //�T�����Ƀt�H�[�}�b�g���ꂽ�������Ԃ�
        return str;
    }
}