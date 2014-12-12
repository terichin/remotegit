package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;

/*
 * ��ʂU��\������N���X
 */
public class Page6View extends View {
    private final static Logger logger = Logger.getLogger(Page6View.class);

    public String render(HashMap session) {
        //"search"�Ƃ������O�Ŋi�[���ꂽ�Ј����P����session����擾����
        MemberBean bean = (MemberBean) session.get("search");

        if (bean != null) {
            System.out.println("�������ʂ͈ȉ���1���ł��B");
            logger.info("�������ʂ͈ȉ���1���ł��B");
            System.out.println();
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
        } else {
            System.out.println("�Y���f�[�^������܂���ł����B");
            logger.error("�Y���f�[�^������܂���ł����B");
            return null;
        }
        System.out.println();
        System.out.println("�ύX���鑮����I�����Ă��������B");
        logger.info("�ύX���鑮����I�����Ă��������B");
        System.out.println();
        for (int i = 2; i <= 7; i++) {
            System.out.println(i + " " + COLUMN_NAME[i]);
            logger.info(i + " " + COLUMN_NAME[i]);
        }

        //�ύX���鑮���ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(2, 7);
        System.out.println();

        return number;
    }
}