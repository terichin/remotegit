package basicws.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
/*
 * ���͎�t���s���N���X�B
 */
public class InputUtility {
    private final static Logger logger = Logger.getLogger(InputUtility.class);

    public static String inputString() {
        return inputString(true);
    }

    public static String inputString(boolean required) {
        //�W�����͂�����͂��󂯕t���邽�߂̃I�u�W�F�N�g���擾����
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            while (true) {
                //�W�����͂���P�s�ǂݍ���
                String input = br.readLine();

                //������false�̏ꍇ�A�����͂Ɋ֌W�Ȃ����͂��ꂽ�l��Ԃ��B
                //������true�̏ꍇ�A�����͂Ȃ�ē��͂𑣂��A�������͂���Ă����
                //���̒l��Ԃ�
                if (required == false || input.length() > 0) {
                    logger.info(input);
                    return input;
                }
                System.out.println("���͕͂K�{�ł��B�ēx���͂��Ă��������B");
                logger.error("���͕͂K�{�ł��B�ēx���͂��Ă��������B");

            }
        } catch (IOException e) {
            System.out.println("�R���\�[������̓��͂Ɏ��s���܂����B");
            System.out.println("�A�v���P�[�V�������I�����܂��B");
            logger.error("�R���\�[������̓��͂Ɏ��s���܂����B"+e.toString());
            logger.error("�A�v���P�[�V�������I�����܂��B");
            System.exit(0);
        }
        return null;

    }

    public static String inputString(int maxLength) {
        return inputString(maxLength, true);
    }

    public static String inputString(int maxLength, boolean required) {
        while (true) {
            //�����̒l(true/false)�Ŗ����̓`�F�b�N�̗L����
            //���f���A���͂��󂯕t����
            String value = inputString(required);

            //���͂��ꂽ�l�̕��������`�F�b�N���A�͈͓��ł����
            //���̒l��Ԃ�
            if (value.length() <= maxLength) {
                return value;
            }

            //�͈͊O�ł���΍ē��͂𑣂�
            System.out.println(maxLength + "�����ȓ��œ��͂��Ă��������B");
            logger.error(maxLength + "�����ȓ��œ��͂��Ă��������B");
            System.out.println();
        }

    }

    public static String inputNumber() {
        while (true) {
            try {
                //�����̓`�F�b�N�����ē��͂��ꂽ�l���擾����
                String str = inputString();

                //���͂��ꂽ�l���������ǂ��������ɕϊ����Ċm�F����
                Integer.parseInt(str);

                //�ϊ��ɐ��������ꍇ�A���͂��ꂽ�l��Ԃ�
                return str;

            } catch (NumberFormatException ex) {
                //�ϊ��Ɏ��s�����ꍇ�A�ē��͂𑣂�
                System.out.println("�����œ��͂��Ă��������B");
                logger.error("�����œ��͂��Ă��������B"+ex.toString());
                System.out.println();
            }

        }
    }

    public static String inputNumber(int min, int max) {
        while (true) {
            //���͂��ꂽ�������擾����
            String str = inputNumber();

            //�����ɕϊ����āA�����Ŏw�肳��Ă���͈͓������`�F�b�N���A
            //�͈͓��̏ꍇ�A���͂��ꂽ�l�i�ϊ��O�̒l�j��Ԃ�
            int value = Integer.parseInt(str);
            if ((min <= value) && (value <= max)) {
                return str;
            }

            //�͈͊O�̏ꍇ�A�ē��͂𑣂�
            System.out.println(min + "����" + max
                    + "�܂ł̐�������͂��Ă��������B");
            System.out.println();
            logger.error(min + "����" + max
                    + "�܂ł̐�������͂��Ă��������B");
        }
    }
}