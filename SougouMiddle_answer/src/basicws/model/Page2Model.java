package basicws.model;

import java.util.HashMap;
/*
 * ���[�h�ԍ��ɉ����ď����𕪊򂷂�N���X
 */
public class Page2Model implements Model {

    public int execute(String parameter, HashMap session) {
        if (parameter.equals("1")) {
            return 10;
        } else if (parameter.equals("2")) {
            //���[�h�ԍ�"2"(�ύX)��"mode"�Ƃ������O��session�Ɋi�[����
            session.put("mode", "2");
            //�����L�[�ԍ�"1"(�Ј��ԍ�)��"key"�Ƃ������O��session�Ɋi�[����
            session.put("key", "1");
            return 4;
        } else if (parameter.equals("3")) {
            //���[�h�ԍ�"3"(�폜)��"mode"�Ƃ������O��session�Ɋi�[����
            session.put("mode", "3");
            //�����L�[�ԍ�"1"(�Ј��ԍ�)��"key"�Ƃ������O��session�Ɋi�[����
            session.put("key", "1");
            return 4;
        } else if (parameter.equals("4")) {
            //���[�h�ԍ�"4"(����)��"mode"�Ƃ������O��session�Ɋi�[����
            session.put("mode", "4");
            return 3;
        } else if (parameter.equals("5")) {
            System.exit(0);
        }
        return -1;
    }
}