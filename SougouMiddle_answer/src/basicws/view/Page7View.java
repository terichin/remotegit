package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * ��ʂV��\������N���X
 */
public class Page7View extends View {
    private final static Logger logger = Logger.getLogger(Page7View.class);

    public String render(HashMap session) {
        //"search"�Ƃ������O�Ŋi�[���ꂽ�Ј����1����session����擾����
        MemberBean bean = (MemberBean) session.get("search");

        if (bean != null) {
            System.out.println("�������ʂ͎���1���ł��B");
            logger.info("�������ʂ͎���1���ł��B");
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
        } else {
            System.out.println("�Y���f�[�^������܂���ł����B");
            logger.error("�Y���f�[�^������܂���ł����B");
            return null;
        }
        System.out.println("�Y���f�[�^���폜���Ă���낵���ł��傤���H");
        logger.error("�Y���f�[�^���폜���Ă���낵���ł��傤���H");
        System.out.println("1 �͂�");
        logger.error("1 �͂�");
        System.out.println("2 ������");
        logger.error("2 ������");

        //�폜�m�F�ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 2);
        return number;
    }
}