/*
 * �Ј����̓o�^�������s���N���X�B
 */
public class Page11 {
    // �o�^����Ј�����MemberBean�Ƃ��Ď󂯎��
    public void execute(MemberBean bean) {
        //�����n���ꂽ�Ј�����\������
        System.out.println("���͓��e�����m�F���������B");
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

        //�o�^�������s�̊m�F���s��
        System.out.println("���Y�f�[�^��o�^���Ă���낵���ł��傤���H");
        System.out.println("1 �͂�");
        System.out.println("2 ������");

        String number = InputUtility.inputNumber(1, 2);

        //�o�^�������s�����Ƃ��m�F���ꂽ�ꍇ�̂݁AMemberBean���g�p���ēo�^�����s����
        if (number.equals("1")) {
            CsvDao.insert(bean);
        }
    }
}