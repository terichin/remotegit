package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���[�U�����폜����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserDeleteAction implements Action {

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
	 * �@�@�\�F�@���[�U���̍폜�����s���郁�\�b�h�B
	 *
	 * ���@���F�@Action�C���^�t�F�[�X�̌`���ɏ]�����N�G�X�g���󂯎��B
	 * �߂�l�F�@���[�U���폜�������́A���[�U���폜������ʂ̃p�X��Ԃ��B
	 *           ���[�U���폜���s���́A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@�Z�b�V���������̉�ʂőI�����ꂽ���[�U�����擾���A
	 *           �w�肳�ꂽ���[�U�̃��[�U�R�[�h���擾����DAO�̃��[�U�폜���\�b�h��
	 *           �Ăяo���B�폜�����������烆�[�U���폜������ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		UserDTO dto = (UserDTO) session.getAttribute("user_dto");
		if (dto == null) {
			// �w��̃��[�U���̎擾�Ɏ��s�����̂ŃG���[��ʂɑJ�ځB
			return "/page/systemerror.jsp";
		}
		int id = dto.getId();
		
		UserDAO dao = new UserDAO();
		int result = dao.delete(id);
		if (result != 1) {
			// ���[�U���̍폜�Ɏ��s�������߃G���[��ʂɑJ�ڂ���B
			return "/page/systemerror.jsp";
		}

		return "/page/userDeleteComplete.jsp";
	}

}
