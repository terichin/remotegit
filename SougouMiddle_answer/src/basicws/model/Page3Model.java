package basicws.model;

import java.util.HashMap;
/*
 * �����L�[�ԍ���session�Ɋi�[����N���X
 */
public class Page3Model implements Model {

    public int execute(String parameter, HashMap session) {
        //����parameter�œn���ꂽ�����L�[�ԍ���"key"�Ƃ������O��session�Ɋi�[����
        session.put("key", parameter);
        return 4;
    }
}