package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * ��ʂW��\������N���X
 */
public class Page8View extends View {
    private final static Logger logger = Logger.getLogger(Page8View.class);

    public String render(HashMap session) {
        System.out.println("�ύX�������͂��Ă��������B");
        logger.info("�ύX�������͂��Ă��������B");
        System.out.println();

        //"key"�Ƃ������O�Ŋi�[���ꂽ�ύX�����ԍ���session����擾����
        int key = Integer.parseInt((String) session.get("key"));

        //�Ј��ԍ��ȊO�̕ύX�������Ƃɍő啶�������Z�b�g����
        int[] length = {-1, 10, 12, 16, 10, 14, 10};

        //session����擾�����ύX�����ԍ��ɉ����āA��L�ŃZ�b�g����
        //�ő啶�����ŕ������`�F�b�N���s���A�R���\�[������
        //�ύX������擾����
        String query = InputUtility.inputString(length[key - 1]);
        System.out.println();

        return query;
    }
}