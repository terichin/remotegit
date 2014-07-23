package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * ���O�A�E�g�������s���N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class LogoutAction implements Action {

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N����p�����[�^�͖����̂ŁA���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@���O�A�E�g���������s���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���O�C����ʂ̃p�X��Ԃ��B
	 * ���@���F�@�Z�b�V������j�����ă��O�C����ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		return "/page/login.jsp";
	}

}
