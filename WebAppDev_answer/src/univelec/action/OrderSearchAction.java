package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���������A�N�V����
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchAction implements Action {

	/*
	 * �@�@�\�F�@�`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���true��Ԃ��B
	 * ���@���F�@�`�F�b�N����p�����[�^�����݂��Ȃ����߁A���true��Ԃ��B
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * �@�@�\�F�@���O�C�����[�U�̒������������擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@��������\����ʂ̃p�X��Ԃ��B
	 * ���@���F�@�Z�b�V�������烍�O�C�����[�U�̏����擾���A���O�C�����[�U���s����
	 *           �����̗��������擾����B����ʂł̓��[�U�R�[�h�ƒ����������
	 *           �K�v�ł��邽�߁A�Z�b�V�����ɂ�����ۑ�����������\����ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		UserDTO user = (UserDTO) session.getAttribute("login_dto");
		int id = user.getId();

		OrderDAO dao = new OrderDAO();
		ArrayList<OrderDTO> list = dao.getOrderList(id);

		session.setAttribute("order_id", id);
		session.setAttribute("order_list", list);

		return "/page/orderSearchResult.jsp";
	}

}
