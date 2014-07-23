package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * �������������N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderCancelAction implements Action {

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N���鍀�ڂ͖������߁A���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@�w��̒��������폜���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@�L�����Z�������������ꍇ�́A�����L�����Z��������ʂ̃p�X��Ԃ��B
	 *           �L�����Z�������s�����ꍇ�́A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@�Z�b�V��������O��ʂŎw�肳�ꂽ���������擾���A��������
	 *           �w�肳�ꂽ�ԍ��̒������폜����B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		OrderDTO dto = (OrderDTO) session.getAttribute("order_dto");
		if (dto == null) {
			// �L�����Z���Ώۂ̒�����񂪌�����Ȃ��̂ŃG���[��ʂ֑J�ڂ���B
			return "/page/systemerror.jsp";
		}

		OrderDAO dao = new OrderDAO();
		int result = dao.delete(dto.getNo());
		if (result != 1) {
			// �L�����Z���Ɏ��s�����̂ŃG���[��ʂ֑J�ځB
			return "/page/systemerror.jsp";
		}

		return "/page/orderCancelComplete.jsp";
	}

}
