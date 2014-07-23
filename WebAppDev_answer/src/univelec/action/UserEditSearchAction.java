package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * �ҏW�Ώۂ̃��[�U�����擾����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserEditSearchAction implements Action {

	private int userId; // �ҏW�Ώۃ��[�U�R�[�h

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h��null�܂��͋󕶎����ǂ������`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// ���[�U�R�[�h�̃`�F�b�N
		String paramId = req.getParameter("id");
		if ((paramId == null) || ("".equals(paramId) == true)) {
			return false;
		}
		try {
			userId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@�X�V�Ώۂ̃��[�U�����擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest������B
	 * �߂�l�F�@���[�U���̎擾�ɐ��������ꍇ�̓��[�U���ҏW��ʂ̃p�X��Ԃ��B
	 *           ���[�U���̎擾�Ɏ��s�����ꍇ�̓G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h�ɕR�t�����[�U�����擾����B�擾����
	 *           ���[�U���͎���ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A
	 *           ���[�U���ҏW��ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.getUser(userId);
		if (dto == null) {
			// �w��̃��[�U���̎擾�Ɏ��s�����̂ŃG���[��ʂɑJ�ځB
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("user_dto", dto);

		return "/page/userEdit.jsp";
	}

}
