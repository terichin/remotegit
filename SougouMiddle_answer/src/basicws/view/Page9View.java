package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * ��ʂX��\������N���X
 */
public class Page9View extends View {
    private final static Logger logger = Logger.getLogger(Page9View.class);

    public String render(HashMap session) {

        // �ύX�f�[�^session������擾����
        String before = (String) session.get("before");
        String after = (String) session.get("after");
        MemberBean bean = (MemberBean) session.get("update");

        System.out.println("�ύX�O��A�Ȃ�тɕύX��f�[�^�͈ȉ��̒ʂ�ł��B");
        logger.info("�ύX�O��A�Ȃ�тɕύX��f�[�^�͈ȉ��̒ʂ�ł��B");
        System.out.println();
        System.out.println("�y�ύX�O�z");
        logger.info("�ύX�O�z");
        System.out.println(before);
        logger.info(before);
        System.out.println();
        System.out.println("�y�ύX��z");
        logger.info("�y�ύX��z");
        System.out.println(after);
        logger.info(after);
        System.out.println();
        System.out.println("�y�ύX��f�[�^�z");
        logger.info("�y�ύX��f�[�^�z");
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
        System.out.println("�Y���f�[�^��ύX���Ă���낵���ł��傤���H");
        logger.info("�Y���f�[�^��ύX���Ă���낵���ł��傤���H");
        System.out.println("1 �͂�");
        logger.info("1 �͂�");
        System.out.println("2 ������");
        logger.info("2 ������");

        //�ύX�m�F�ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 2);
        System.out.println();

        return number;
    }
}