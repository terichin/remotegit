package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * �o�^����Ј������擾���A�o�^�����̎��s�𐧌䂷��N���X
 */
public class Page11Model implements Model {

    public int execute(String parameter, HashMap session) {
        //����parameter�œn���ꂽ�o�^�m�F�ԍ���"1"�̏ꍇ�̂ݓo�^����
        if (parameter.equals("1")) {
            MemberBean bean = (MemberBean) session.get("insert");
            CsvDao.insert(bean);
        }
        return 2;
    }
}