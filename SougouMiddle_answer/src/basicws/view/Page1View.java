package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * ��ʂP��\������N���X
 */
public class Page1View extends View {
    private final static Logger logger = Logger.getLogger(Page1View.class);

    public String render(HashMap session) {
        System.out.println("�Ј� or �l�����S���҂�I�����Ă��������B");
        logger.info("�Ј� or �l�����S���҂�I�����Ă��������B");
        System.out.println();
        System.out.println("1 �Ј�");
        logger.info("1 �Ј�");
        System.out.println("2 �l���S����");
        logger.info("2 �l���S����");

        //�A�N�^�[�ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 2);

        return number;
    }
}