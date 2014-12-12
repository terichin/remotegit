package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
/*
 * �ύX�Ώۂ̎Ј������擾���A���̏����������s���N���X
 */
public class Page8Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"key"�Ƃ������O�Ŋi�[���ꂽ�ύX�����ԍ���session����擾����
        int key = Integer.parseInt((String) session.get("key"));
        //"search"�Ƃ������O�Ŋi�[���ꂽ�Ј����1����session����擾����
        MemberBean bean = (MemberBean) session.get("search");

        // �ύX�O�f�[�^�̎擾�ƕύX��f�[�^�̏㏑���𑱂��Ď��s
        String before = null;
        switch (key) {
            case 2:
                before = bean.getName();
                bean.setName(parameter);
                break;
            case 3:
                before = bean.getBusho();
                bean.setBusho(parameter);
                break;
            case 4:
                before = bean.getShikaku();
                bean.setShikaku(parameter);
                break;
            case 5:
                before = bean.getTokugi();
                bean.setTokugi(parameter);
                break;
            case 6:
                before = bean.getHobby();
                bean.setHobby(parameter);
                break;
            case 7:
                before = bean.getHometown();
                bean.setHometown(parameter);
                break;
        }

        //�ύX�O�̕ύX������"before"�Ƃ������O��session�Ɋi�[����
        session.put("before", before);
        //�ύX��̕ύX������"after"�Ƃ������O��session�Ɋi�[����
        session.put("after", parameter);
        //�ύX��̎Ј�����"update"�Ƃ������O��session�Ɋi�[����
        session.put("update", bean);

        return 9;
    }
}