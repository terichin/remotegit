package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * �����ԍ��ƕR�t�����������擾����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchOneAction implements Action {

	private int orderNo; // �����ԍ�

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂���钍���ԍ��ɑ΂���null�`�F�b�N�Ɛ��l�`�F�b�N���s���B
	 */
	public boolean check(HttpServletRequest req) {
		// �����ԍ��̃`�F�b�N
		String paramNo = req.getParameter("no");
		if ((paramNo == null) || ("".equals(paramNo) == true)) {
			return false;
		}
		try {
			orderNo = Integer.parseInt(paramNo);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@�w�肳�ꂽ�����ԍ��̒��������擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���������擾�ł���΁A�����L�����Z����ʂ̃p�X��Ԃ��B
	 *           ���������擾�ł��Ȃ���΁A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ�����ԍ����g�p����DBMS���璍�������擾����B
	 *           �������͎���ʂ̕\���₻�̌�̃L�����Z�������Ŏg�p���邽��
	 *           �Z�b�V�����ɕۑ����A�����L�����Z����ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		OrderDAO dao = new OrderDAO();
		OrderDTO dto = dao.getOrder(orderNo);
		if (dto == null) {
			// �w��̔ԍ��̒�����񂪌�����Ȃ��̂ŃG���[��ʂɑJ�ځB
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("order_dto", dto);

		return "/page/orderCancel.jsp";
	}

}
