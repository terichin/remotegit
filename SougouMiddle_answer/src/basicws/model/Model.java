package basicws.model;

import java.util.HashMap;
/*
 * �eModel�N���X�̃C���^�[�t�F�[�X
 * �eModel�N���X�͂��̃C���^�[�t�F�[�X���������č쐬����
 */
public interface Model {
    int execute(String parameter, HashMap session);
}