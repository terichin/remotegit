package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * �w�肳�ꂽ���[�U�̒����������擾����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchUserAction implements Action {

	private int userId; // ���[�U�R�[�h

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂���郆�[�U�R�[�h�ɑ΂���null�`�F�b�N�Ɛ��l�`�F�b�N���s���B
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
	 * �@�@�\�F�@�w��̃��[�U�̒������������擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@��������\����ʂ̃p�X��Ԃ��B
	 * ���@���F�@check���\�b�h�Ŏ擾�������[�U�R�[�h���g�p���A�w��̃��[�U���s����
	 *           �����̗��������擾����B����ʂł̓��[�U�R�[�h�ƒ����������
	 *           �K�v�ł��邽�߁A�Z�b�V�����ɂ�����ۑ�����������\����ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		OrderDAO dao = new OrderDAO();
		ArrayList<OrderDTO> list = dao.getOrderList(userId);

		HttpSession session = req.getSession(false);
		session.setAttribute("order_id", userId);
		session.setAttribute("order_list", list);

		return "/page/orderSearchResult.jsp";
	}

}
