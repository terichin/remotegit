package basicws.view;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.entity.MemberBean;
import basicws.util.InputUtility;
/*
 * ��ʂT��\������N���X
 */
public class Page5View extends View {
    private final static Logger logger = Logger.getLogger(Page5View.class);

    public String render(HashMap session) {
        //"search"�Ƃ������O�Ŋi�[���ꂽ�Ј���񃊃X�g��session����擾����
        ArrayList<MemberBean> list =
                (ArrayList<MemberBean>)session.get("search");

        if (list != null && list.size() != 0) {
            System.out.println("�������ʂ͈ȉ��ł��B");
            logger.info("�������ʂ͈ȉ��ł��B");
            System.out.println();
            for (MemberBean bean : list) {
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
            }
        } else {
            System.out.println("�Y���f�[�^������܂���ł����B");
            logger.error("�Y���f�[�^������܂���ł����B");
        }
        System.out.println();
        System.out.println("���̃A�N�V������I�����Ă��������B");
        logger.info("���̃A�N�V������I�����Ă��������B");

        //"actor"�Ƃ������O�Ŋi�[���ꂽ�A�N�^�[����session����擾����
        String actor = (String) session.get("actor");
        if (actor.equals("1")) {
            //�A�N�^�[�ԍ���1(�Ј�)�̏ꍇ�́A�Č������I��
            System.out.println("1 �����L�[�I���ɖ߂�");
            logger.info("1 �����L�[�I���ɖ߂�");
            System.out.println("2 �I��");
            logger.info("2 �I��");
            System.out.println();
        } else {
            //�A�N�^�[�ԍ���2(�l���S����)�̏ꍇ�́A���[�h�I�����A�Č���
            System.out.println("1 ���[�h�I���ɖ߂�");
            logger.info("1 ���[�h�I���ɖ߂�");
            System.out.println("2 �����L�[�I���ɖ߂�");
            logger.info("2 �����L�[�I���ɖ߂�");
            System.out.println();
        }
        //���̃A�N�V�����ԍ����R���\�[������擾����
        String number = InputUtility.inputNumber(1, 2);

        return number;
    }
}