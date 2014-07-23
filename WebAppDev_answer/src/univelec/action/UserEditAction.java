package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���[�U����ҏW����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserEditAction implements Action {

	private int userId; // ���[�U�R�[�h
	private String kana; // ����
	private String mail; // ���[���A�h���X
	private String name; // ���O
	private String phone; // �d�b�ԍ�
	private String password; // �p�X���[�h
	private int privilege; // ����

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U���̊e�ҏW���e���`�F�b�N����B
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

		// ���O�̃`�F�b�N
		name = req.getParameter("name");
		if ((name == null) || ("".equals(name) == true)) {
			return false;
		}

		// ���Ȃ̃`�F�b�N
		kana = req.getParameter("kana");
		if ((kana == null) || ("".equals(kana) == true)) {
			return false;
		}

		// �d�b�ԍ��̃`�F�b�N
		phone = req.getParameter("phone");
		if ((phone == null) || ("".equals(phone) == true)) {
			return false;
		}

		// ���[���A�h���X�̃`�F�b�N
		mail = req.getParameter("mail");
		if ((mail == null) || ("".equals(mail) == true)) {
			return false;
		}

		// �p�X���[�h�̃`�F�b�N
		password = req.getParameter("password");
		if ((password == null) || ("".equals(password) == true)) {
			return false;
		}

		// ���[�U�����̃`�F�b�N
		String paramPrivilege = req.getParameter("privilege");
		if ((paramPrivilege == null) || ("".equals(paramPrivilege) == true)) {
			// �`�F�b�N�{�b�N�X���`�F�b�N����Ă��Ȃ���΁A���͑��M����Ȃ��B
			privilege = 0;
		} else {
			privilege = 1;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@���[�U���̍X�V�����s���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���[�U���X�V�����̏ꍇ�̓��[�U���ҏW������ʂ̃p�X��Ԃ��B
	 *           ���[�U���X�V���s�̏ꍇ�̓G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ�p�����[�^���g�p����DTO�I�u�W�F�N�g�𐶐����A
	 *           UserDAO�̃��\�b�h��DTO��n���ă��[�U�����X�V����B
	 *           �X�V�Ɏg�p�������͎���ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A
	 *           ���[�U���ҏW������ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDTO dto =
			new UserDTO(userId, name, kana, phone, mail, password, privilege);

		UserDAO dao = new UserDAO();
		int result = dao.edit(dto);
		if (result != 1) {
			// ���[�U���X�V�Ɏ��s�����̂ŃG���[��ʂɑJ�ڂ���B
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("user_dto", dto);

		return "/page/userEditComplete.jsp";
	}

}
