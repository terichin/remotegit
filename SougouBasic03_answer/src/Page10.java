/*
 * �Ј����̓o�^�����������Ȃ��o�^�������s���N���X��
 * �����n���N���X�B
 */
public class Page10 {

    public void execute() {
        System.out.println("�Ј����o�^���s���܂��B");
        System.out.println("�Ј��̓o�^���e����͂��Ă�������");
        System.out.println(MemberMain.COLUMN_NAME[1] + "�F");
        String shainNo;

        do {
            //�Ј��ԍ����R���\�[������擾����
            shainNo = InputUtility.inputNumber(1, 9999999);

            // �[���T�v���X(�V���ȉ��̂Ƃ��ɁA�擪��0�Ŗ��߂�j����
            int length = shainNo.length();
            if (length < 7) {
                for (int i = 0; i < 7 - length; i++) {
                    shainNo = "0" + shainNo;
                }
            }

            //�Ј��ԍ������łɑ��݂��Ă��Ȃ����d���`�F�b�N���s��
            if (CsvDao.isDuplicateKey(shainNo)) {
                System.out.println("�Ј��ԍ����d�����Ă��܂��B�ēx���͂��Ă��������B");
            } else {
                break;
            }
        } while (true);

        //�Ј�����10�����ȓ��ŃR���\�[������擾����
        System.out.println(MemberMain.COLUMN_NAME[2] + "�F");
        String shainName = InputUtility.inputString(10);

        //��������12�����ȓ��ŃR���\�[������擾����
        System.out.println(MemberMain.COLUMN_NAME[3] + "�F");
        String bushoName = InputUtility.inputString(12);

        //���i��16�����ȓ��ŃR���\�[������擾����
        System.out.println(MemberMain.COLUMN_NAME[4] + "�F");
        String shikaku = InputUtility.inputString(16, false);

        //���Z��10�����ȓ��ŃR���\�[������擾����
        System.out.println(MemberMain.COLUMN_NAME[5] + "�F");
        String tokugi = InputUtility.inputString(10, false);

        //���14�����ȓ��ŃR���\�[������擾����
        System.out.println(MemberMain.COLUMN_NAME[6] + "�F");
        String hobby = InputUtility.inputString(14, false);

        //�o�g��10�����ȓ��ŃR���\�[������擾����
        System.out.println(MemberMain.COLUMN_NAME[7] + "�F");
        String hometown = InputUtility.inputString(10);

        //���͂��ꂽ�e���ڃf�[�^��z��ɂ܂Ƃ߁A
        //���̔z��v�f������MemberBean���쐬����
        String[] array = {shainNo, shainName, bushoName, shikaku, tokugi, hobby, hometown};
        MemberBean bean = new MemberBean(array);

        //��L�ō쐬����MemberBean��Page11�N���X��execute()���\�b�h��
        //�����n���A�o�^�����������Ȃ�
        Page11 page = new Page11();
        page.execute(bean);
    }
}