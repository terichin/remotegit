package basicws.model;

import java.util.ArrayList;
import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * �폜����Ј������擾���A�폜�����̎��s�𐧌䂷��N���X
 */
public class Page7Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"search"�Ƃ������O�Ŋi�[���ꂽ�Ј����1����session����擾����
        MemberBean bean = (MemberBean) session.get("search");

        if (bean == null) {
            return 4;
        } else {
            //����parameter�œn���ꂽ�폜�m�F�ԍ���"1"�̏ꍇ�̂ݍ폜����
            if (parameter.equals("1")) {
                CsvDao.delete(bean);
            }
            return 2;
        }
    }
}