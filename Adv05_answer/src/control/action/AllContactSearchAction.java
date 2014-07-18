package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class AllContactSearchAction implements Action {
	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N����p�����[�^�͖������߁A���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@�d�b�ԍ����̈ꗗ���擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@�d�b�ԍ����ꗗ��ʂ̃p�X��Ԃ��B
	 * ���@���F�@DBMS����o�^����Ă���d�b�ԍ����ꗗ���擾����B�擾�����ꗗ��
	 *           ����ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A�d�b�ԍ����ꗗ��ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		NewContactDAO dao = new NewContactDAO();
		ArrayList<ContactDTO> list = dao.getContactList();
		HttpSession session = req.getSession(false);
		session.setAttribute("contact_list", list);
		return "/page/contactSearch.jsp";
	}
}