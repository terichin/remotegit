package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * ���11��\������N���X
 */
public class Page11View extends View {
    private final static Logger logger = Logger.getLogger(Page11View.class);

    public String render(HashMap session) {
        //"insert"�Ƃ������O�Ŋi�[���ꂽ�Ј����P����session����擾����
        MemberBean bean = (MemberBean) session.get("insert");

        System.out.println("���͓��e�����m�F���������B");
        logger.info("���͓��e�����m�F���������B");
        System.out.println(columnNameFormat(
                COLUMN_NAME[1]) + "�F" + bean.getNo());
        logger.info(columnNameFormat(
                COLUMN_NAME[1]) + "�F" + bean.getNo());
        System.out.println(columnNameFormat(
                COLUMN_NAME[2]) + "�F" + bean.getName());
        logger.info(columnNameFormat(
                COLUMN_NAME[2]) + "�F" + bean.getName());
        System.out.println(columnNameFormat(
                COLUMN_NAME[3]) + "�F" + bean.getBusho());
        logger.info(columnNameFormat(
                COLUMN_NAME[3]) + "�F" + bean.getBusho());
        System.out.println(columnNameFormat(
                COLUMN_NAME[4]) + "�F" + bean.getShikaku());
        logger.info(columnNameFormat(
                COLUMN_NAME[4]) + "�F" + bean.getShikaku());
        System.out.println(columnNameFormat(
                COLUMN_NAME[5]) + "�F" + bean.getTokugi());
        logger.info(columnNameFormat(
                COLUMN_NAME[5]) + "�F" + bean.getTokugi());
        System.out.println(columnNameFormat(
                COLUMN_NAME[6]) + "�F" + bean.getHobby());
        logger.info(columnNameFormat(
                COLUMN_NAME[6]) + "�F" + bean.getHobby());
        System.out.println(columnNameFormat(
                COLUMN_NAME[7]) + "�F" + bean.getHometown());
        logger.info(columnNameFormat(
                COLUMN_NAME[7]) + "�F" + bean.getHometown());
        System.out.println();
        System.out.println("�Y���f�[�^��o�^���Ă���낵���ł��傤���H");
        logger.info("�Y���f�[�^��o�^���Ă���낵���ł��傤���H");
        System.out.println("1 �͂�");
        logger.info("1 �͂�");
        System.out.println("2 ������");
        logger.info("2 ������");

        //�o�^�m�F�ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 2);
        return number;
    }
}