package basicws.model;

import java.util.HashMap;
/*
 * �A�N�^�[�ԍ��ɉ����ď����𕪊򂷂�N���X
 */
public class Page1Model implements Model {

    public int execute(String parameter, HashMap session) {
        //�A�N�^�[�ԍ��i1:�Ј�,2:�l���S���ҁj�ɂ�镪��
        if (parameter.equals("1")) {
            //�A�N�^�[�ԍ���1�i�Ј��j�̏ꍇ
            //�A�N�^�[�ԍ���"actor"�Ƃ������O��session�Ɋi�[����
            session.put("actor", "1");
            //���[�h�ԍ�4(����)��"mode"�Ƃ������O��session�Ɋi�[����
            session.put("mode", "4");
            return 3;

        } else {
            //�A�N�^�[�ԍ���2�i�l���S���ҁj�̏ꍇ
            //�A�N�^�[�ԍ���"actor"�Ƃ������O��session�Ɋi�[����
            session.put("actor", "2");
            return 2;
        }
    }
}