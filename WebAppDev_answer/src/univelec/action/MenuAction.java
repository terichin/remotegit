package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * ���j���[��ʂɑJ�ڂ���N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class MenuAction implements Action {

	/*
	 * �@�@�\�F�@�`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N���s���p�����[�^�͖������߁A���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@���j���[��ʂւ̑J�ڂ����s���郁�\�b�h�B
	 *
	 * ���@���F�@Action�C���^�t�F�[�X�̌`���ɏ]�����N�G�X�g���󂯎��B
	 * �߂�l�F�@���j���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���j���[��ʂ֑J�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/page/menu.jsp";
	}

}
