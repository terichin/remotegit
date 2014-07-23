package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * Model�̌`�����`����C���^�t�F�[�X
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public interface Action {

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 */
	boolean check(HttpServletRequest req);

	/*
	 * �@�@�\�F�@�A�N�V�������s���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@�J�ڐ�JSP�̃p�X�B
	 */
	String execute(HttpServletRequest req) throws DAOException;

}
