/*
 * �Ј����̓o�^�������s���N���X�B
 */
public class Page11 {

    public void execute(String[] array) {
        //�����n���ꂽ�Ј�����\������
        System.out.println("���͓��e�����m�F���������B");
        for (int i = 0; i < 7; i++) {
            System.out.println(MemberMain.columnNameFormat(
                MemberMain.COLUMN_NAME[i + 1]) + "�F" + array[i]);
        }
        System.out.println();

        //�o�^�������s�̊m�F���s��
        System.out.println("���Y�f�[�^��o�^���Ă���낵���ł��傤���H");
        System.out.println("1 �͂�");
        System.out.println("2 ������");

        String number = InputUtility.inputNumber(1, 2);

        //�o�^�������s�����Ƃ��m�F���ꂽ�ꍇ�̂݁A�o�^�����s����
        if (number.equals("1")) {
            CsvDao.insert(array);
        }
    }
}