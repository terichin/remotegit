package control.action;
import javax.servlet.http.*;
import control.dao.*;

public class EmployeeInfoSearchScreenAction implements Action {
	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N���鍀�ڂ͑��݂��Ȃ����߁A���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@���[�U��񌟍���ʂւ̑J�ڂ����s���郁�\�b�h�B
	 *
	 * ���@���F�@Action�C���^�t�F�[�X�̌`���ɏ]�����N�G�X�g���󂯎��B
	 * �߂�l�F�@���[�U��񌟍���ʂ̃p�X��Ԃ��B
	 * ���@���F�@���[�U��񌟍���ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/html/employeeSearch.html";
	}
}