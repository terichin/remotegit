package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * �ύX����Ј������擾���A�ύX�����ԍ���session�Ɋi�[����N���X
 */
public class Page6Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"search"�Ƃ������O�Ŋi�[���ꂽ�Ј����1����session����擾����
        MemberBean bean = (MemberBean) session.get("search");

        if (bean == null) {
            return 4;
        } else {
            //����parameter�œn���ꂽ�ύX�����ԍ���"key"�Ƃ������O��
            //session�Ɋi�[����
            session.put("key", parameter);
            return 8;
        }
    }
}