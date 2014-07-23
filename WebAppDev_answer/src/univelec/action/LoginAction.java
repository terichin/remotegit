package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���O�C���������s���N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class LoginAction implements Action {

	private int id; // ���[�U�R�[�h
	private String password; // �p�X���[�h

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h�ƃp�X���[�h��null�܂��͋󕶎��łȂ���
	 *           �`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// ���[�U�R�[�h�̃`�F�b�N
		String paramId = req.getParameter("id");
		if ((paramId == null) || ("".equals(paramId))) {
			return false;
		}
		try {
			id = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}

		// �p�X���[�h�̃`�F�b�N
		password = req.getParameter("password");
		if ((password == null) || ("".equals(password))) {
			return false;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@���O�C�����������s���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���O�C���������ɂ̓��j���[��ʂ̃p�X��Ԃ��B
	 *           ���O�C�����s���ɂ̓G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h�ƃp�X���[�h���g�p���āA���͂��ꂽ���
	 *           DBMS�ɓo�^����Ă��邱�Ƃ��m�F����B���DBMS�ɓo�^����Ă����
	 *           ���������[�U�Ƃ݂Ȃ��ăZ�b�V�����𐶐����A���͂��ꂽ���[�U����
	 *           �Z�b�V�����ɕۑ����ă��j���[��ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDTO user = new UserDTO(id, password);
		UserDAO dao = new UserDAO();
		if (dao.checkLogin(user) != true) {
			// ���[�U�F�؂Ɏ��s�����̂ŃG���[��ʂ�
			return "/page/systemerror.jsp";
		}

		// ���O�C���ɐ��������̂ŃZ�b�V�����𐶐����A���[�U����o�^�B
		HttpSession session = req.getSession(true);
		session.setAttribute("login_dto", user);

		return "/page/menu.jsp";
	}

}
