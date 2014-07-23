package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���[�U�̈ꗗ���擾����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserSearchAction implements Action {

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
	 * �@�@�\�F�@���[�U���̈ꗗ���擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest������B
	 * �߂�l�F�@���[�U���ꗗ��ʂ̃p�X��Ԃ��B
	 * ���@���F�@DBMS����o�^����Ă��郆�[�U���ꗗ�����擾����B�擾�����ꗗ
	 *           �͎���ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A���[�U���ꗗ���
	 *           �ɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDAO dao = new UserDAO();
		ArrayList<UserDTO> list = dao.getUserList();

		HttpSession session = req.getSession(false);
		session.setAttribute("user_list", list);

		return "/page/userSearch.jsp";
	}
}
