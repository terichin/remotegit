package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.CsvDao;
import basicws.util.InputUtility;
/*
 * ���10��\������N���X
 */
public class Page10View extends View {

    private final static Logger logger = Logger.getLogger(Page10View.class);

    public String render(HashMap session) {
        System.out.println("�Ј����o�^���s���܂��B");
        System.out.println("�Ј��̓o�^���e����͂��Ă�������");
        logger.info("�Ј����o�^���s���܂��B");
        logger.info("�Ј��̓o�^���e����͂��Ă�������");

        System.out.println(COLUMN_NAME[1] + "�F");
        logger.info(COLUMN_NAME[1] + "�F");
        String no;
        do {
            //�o�^����Ј��ԍ����R���\�[������擾����
            no = InputUtility.inputString(7, false);

            // �[���T�v���X(�V���ȉ��̂Ƃ��ɁA�擪��0�Ŗ��߂�j����
            int length = no.length();
            if (length < 7) {
                for (int i = 0; i < 7 - length; i++) {
                    no = "0" + no;
                }
            }

            try {
                Integer.parseInt(no);
            } catch (NumberFormatException e) {
                System.out.println("�����œ��͂��Ă��������B");
                logger.info(no);
                logger.error("�����œ��͂��Ă��������B");
                continue;
            }

            //�Ј��ԍ������łɑ��݂��Ă��Ȃ����d���`�F�b�N���s��
            if (CsvDao.isDuplicateKey(no)) {
                System.out.println("�Ј��ԍ����d�����Ă��܂��B"
                        + "�ēx���͂��Ă��������B");
                logger.info(no);
                logger.error("�Ј��ԍ����d�����Ă��܂��B"
                        + "�ēx���͂��Ă��������B");
            } else {
                break;
            }
        } while (true);

        logger.info(no);

        //�Ј�����10�����ȓ��ŃR���\�[������擾����
        System.out.println(COLUMN_NAME[2] + "�F");
        logger.info(COLUMN_NAME[2] + "�F");
        String name = InputUtility.inputString(10);
        logger.info(name);

        //��������12�����ȓ��ŃR���\�[������擾����
        System.out.println(COLUMN_NAME[3] + "�F");
        logger.info(COLUMN_NAME[3] + "�F");
        String busho = InputUtility.inputString(12);
        logger.info( busho);

        //���i��16�����ȓ��ŃR���\�[������擾����
        System.out.println(COLUMN_NAME[4] + "�F");
        logger.info(COLUMN_NAME[4] + "�F");
        String shikaku = InputUtility.inputString(16, false);
        logger.info(shikaku);

        //���Z��10�����ȓ��ŃR���\�[������擾����
        System.out.println(COLUMN_NAME[5] + "�F");
        logger.info(COLUMN_NAME[5] + "�F");
        String tokugi = InputUtility.inputString(10, false);
        logger.info(tokugi);

        //���14�����ȓ��ŃR���\�[������擾����
        System.out.println(COLUMN_NAME[6] + "�F");
        logger.info(COLUMN_NAME[6] + "�F");
        String hobby = InputUtility.inputString(14, false);
        logger.info(hobby);

        //�o�g��10�����ȓ��ŃR���\�[������擾����
        System.out.println(COLUMN_NAME[7] + "�F");
        logger.info(COLUMN_NAME[7] + "�F");
        String hometown = InputUtility.inputString(10);
        logger.info(hometown);

        //��L�Ŏ擾�����e���ڃf�[�^���J���}�ŋ�؂��ĂP�̕�����ɂ܂Ƃ߂�
        String result =
                no + ","
                + name + ","
                + busho + ","
                + shikaku + ","
                + tokugi + ","
                + hobby + ","
                + hometown;

        return result;
    }
}