package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * �ύX�Ώۂ̎Ј������擾���A�ύX�����̎��s�𐧌䂷��N���X
 */
public class Page9Model implements Model {

    public int execute(String parameter, HashMap session) {
        //����parameter�œn���ꂽ�ύX�m�F�ԍ���"1"�̏ꍇ�̂ݕύX����
        if (parameter.equals("1")) {
            //"update"�Ƃ������O�Ŋi�[���ꂽ�Ј����1����session����擾����
            MemberBean bean = (MemberBean) session.get("update");
            CsvDao.update(bean);
        }
        return 2;
    }
}