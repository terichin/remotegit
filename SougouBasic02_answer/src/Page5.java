/*
 * �Ј����̌������ʂ�\������N���X
 */
public class Page5 {
    //�������ʂ�MemberBean�������Ƃ��Ď󂯎��
    public void execute(MemberBean bean) {

        //�������ʂ�����ꍇ�͓��e��\������
        if (bean != null) {
            System.out.println("�������ʂ͈ȉ���1���ł��B");
            System.out.println();
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[1]) + "�F" + bean.getNo());
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[2]) + "�F" + bean.getName());
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[3]) + "�F" + bean.getBusho());
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[4]) + "�F" + bean.getShikaku());
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[5]) + "�F" + bean.getTokugi());
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[6]) + "�F" + bean.getHobby());
            System.out.println(MemberMain.columnNameFormat(
                    MemberMain.COLUMN_NAME[7]) + "�F" + bean.getHometown());
            System.out.println();
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