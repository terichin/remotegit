package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * ��ʂQ��\������N���X
 */
public class Page2View extends View {
    private final static Logger logger = Logger.getLogger(Page2View.class);

    public String render(HashMap session) {
        System.out.println("���[�h��I�����Ă�������");
        logger.info("���[�h��I�����Ă�������");
        System.out.println();
        System.out.println("1 �Ј����o�^");
        logger.info("1 �Ј����o�^");
        System.out.println("2 �Ј����ύX");
        logger.info("2 �Ј����ύX");
        System.out.println("3 �Ј����폜");
        logger.info("3 �Ј����폜");
        System.out.println("4 �Ј���񌟍�");
        logger.info("4 �Ј���񌟍�");
        System.out.println("5 �I��");
        logger.info("5 �I��");
        System.out.println();

        //���[�h�ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 5);
        System.out.println();

        return number;
    }
}