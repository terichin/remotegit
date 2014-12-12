package basicws.model;

import java.util.ArrayList;
import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * ���[�h�ԍ��ɂ���ď����𕪊򂷂�N���X
 */
public class Page4Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"key"�Ƃ������O�Ŋi�[���ꂽ�����L�[��session����擾����
        int key = Integer.parseInt((String) session.get("key"));
        //"mode"�Ƃ������O�Ŋi�[���ꂽ���[�h�ԍ���session����擾����
        int mode = Integer.parseInt((String) session.get("mode"));

        if (mode == 2 || mode == 3) {
            //����parameter�œn���ꂽ�����L�[���[�h(�Ј��ԍ�)�Ō������A
            //�Ј������P���擾����
            MemberBean bean = CsvDao.searchById(parameter);
            //�擾�����Ј�����"search"�Ƃ������O��session�Ɋi�[����
            session.put("search", bean);

            if (mode == 2) {
                return 6;
            } else {
                return 7;
            }
        } else {
            //session����擾���������L�[�ƈ���parameter�œn���ꂽ
            //�����L�[���[�h�Ō������A�Ј������擾����
            ArrayList<MemberBean> list = CsvDao.search(key, parameter);
            //�擾�����Ј���񃊃X�g��"search"�Ƃ������O��session�Ɋi�[����
            session.put("search", list);

            return 5;
        }
    }
}