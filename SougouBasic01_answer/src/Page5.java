/*
 * �Ј����̌������ʂ�\������N���X
 */
public class Page5 {

    public void execute(String[] array) {

        //�������ʂ�����ꍇ�͓��e��\������
        if (array != null) {
            System.out.println("�������ʂ͈ȉ��̂P���ł��B");
            System.out.println();
            for (int i = 0; i < 7; i++) {
                System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[i + 1]) + "�F" + array[i]);
            }
        } else {
            System.out.println("�Y���f�[�^������܂���ł����B");
        }
        System.out.println();
        System.out.println("���̃A�N�V������I�����Ă��������B");
        System.out.println("1 ���[�h�I���ɖ߂�");
        System.out.println("2 �����L�[�I���ɖ߂�");
        System.out.println();

        //�J�ڐ�����肷��ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 2);

        if (number.equals("2")) {
            Page3 page = new Page3();
            page.execute();
        }
    }
}