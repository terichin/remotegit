package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.util.InputUtility;
/*
 * ��ʂS��\������N���X
 */
public class Page4View extends View {
    private final static Logger logger = Logger.getLogger(Page4View.class);

    public String render(HashMap session) {
        //"key"�Ƃ������O�Ŋi�[���ꂽ�����L�[��session����擾����
        int key = Integer.parseInt((String) session.get("key"));
        System.out.println(COLUMN_NAME[key] + "�ŎЈ��������s���܂��B");
        logger.info(COLUMN_NAME[key] + "�ŎЈ��������s���܂��B");
        System.out.println("�����L�[���[�h����͂��Ă��������B");
        logger.info("�����L�[���[�h����͂��Ă��������B");
        System.out.println();

        //�����L�[���[�h���R���\�[������擾����
        String query = InputUtility.inputString();
        System.out.println();

        return query;
    }
}