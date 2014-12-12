package basicws.view;

import java.util.HashMap;

import org.apache.log4j.Logger;
/*
 * �eView�N���X�̊��N���X
 * �eView�N���X�͂��̃N���X���p�����č쐬����
 */
public class View {
    private final static Logger logger = Logger.getLogger(View.class);

    //�Ј����̍��ږ�
    public static final String[] COLUMN_NAME = {
        "",
        "�Ј��R�[�h",
        "�Ј���",
        "����",
        "���i",
        "���Z",
        "�",
        "�o�g"
    };

    public String columnNameFormat(String str) {
        //�����̕����񐔂ƂT�����̍����擾
        int count = 5 - str.length();

        //5�����ɂȂ�܂ň����ɋ󔒕�����ǉ�
        for (int i = 0; i < count; i++) {
            str += "�@";
        }
        //5�����Ƀt�H�[�}�b�g���ꂽ�������Ԃ�
        return str;
    }

    public String render(HashMap session) {
        System.out.println("Don't call this method. Please override it.");
        logger.error("Don't call this method. Please override it.");
        System.exit(0);
        return null;
    }
}