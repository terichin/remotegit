package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
/*
 * �o�^����Ј������쐬���Asession�Ɋi�[����N���X
 */
public class Page10Model implements Model {

    public int execute(String parameter, HashMap session) {

        //����parameter�œn���ꂽ�o�^�p�̎Ј������J���}�ŋ�؂���
        //�z��Ƃ��Ď擾����
        String[] record = parameter.split(",");

        // �[���T�v���X(7���ȉ��̂Ƃ��ɁA�擪��0�Ŗ��߂�j����
        int length = record[0].length();
        if (length < 7) {
            for (int i = 0; i < 7 - length; i++) {
                record[0] = "0" + record[0];
            }
        }

        //�擾�����z��v�f��ێ�����MemberBean���쐬����
        MemberBean bean = new MemberBean(record);

        //��L�ō쐬�����o�^�p��MemberBean��"insert"�Ƃ������O��session�Ɋi�[����
        session.put("insert", bean);
        
        return 11;
    }
}