package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * ��ʑJ��(�����L�[�I�����/���[�h�I�����/�I��)�𐧌䂷��N���X
 */
public class Page5Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"actor"�Ƃ������O�Ŋi�[���ꂽ�A�N�^�[����session����擾����
        String actor = (String) session.get("actor");
        if (actor.equals("1")) {
            //�A�N�^�[�ԍ���1(�Ј�)�̏ꍇ�́A�����L�[�I����ʂ��I��
            if (parameter.equals("1")) {
                return 3;
            } else {
                System.exit(0);
            }
        } else {
            //�A�N�^�[�ԍ���2(�l���S����)�̏ꍇ�́A���[�h�I����ʂ������L�[�I�����
            if (parameter.equals("1")) {
                return 2;
            } else {
                return 3;
            }
        }
        return -1;
    }
}