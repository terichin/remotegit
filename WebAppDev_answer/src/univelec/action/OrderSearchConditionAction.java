package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * ��������������ʑJ�ڃA�N�V�����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchConditionAction implements Action {

	/*
	 * �@�@�\�F�@�`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N���鍀�ڂ��Ȃ����߁A���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@��������������ʂɑJ�ڂ��郁�\�b�h�B
	 *
	 * ���@���F�@Action�C���^�t�F�[�X�̌`���ɏ]�����N�G�X�g���󂯎��B
	 * �߂�l�F�@�����������͉�ʂ̃p�X��Ԃ��B
	 * ���@���F�@���s���鏈���͑��݂����A�����������͉�ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/page/orderSearch.jsp";
	}

}
