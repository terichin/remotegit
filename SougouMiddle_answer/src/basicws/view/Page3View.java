package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * ��ʂR��\������N���X
 */
public class Page3View extends View {
    private final static Logger logger = Logger.getLogger(Page3View.class);

    public String render(HashMap session) {

        System.out.println("�Ј��������s���܂��B");
        logger.info("�Ј��������s���܂��B");
        System.out.println("�Ј��̌����L�[��I�����Ă��������B");
        logger.info("�Ј��̌����L�[��I�����Ă��������B");
        System.out.println();

        for (int i = 1; i <= 7; i++) {
            System.out.println(i + " " + COLUMN_NAME[i]);
            logger.info(i + " " + COLUMN_NAME[i]);
        }
        System.out.println();

        //�����L�[�̔ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 7);
        System.out.println();

        return number;
    }
}