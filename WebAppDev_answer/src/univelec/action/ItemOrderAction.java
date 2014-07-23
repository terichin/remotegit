package univelec.action;
import java.sql.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���i�𒍕�����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemOrderAction implements Action {

	private int quantity; // ����

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ���ʂ�null�܂��͋󕶎��łȂ����Ƃ��`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// ���ʂ̃`�F�b�N
		String paramQuantity = req.getParameter("quantity");
		if ((paramQuantity == null) || ("".equals(paramQuantity))) {
			return false;
		}
		try {
			quantity = Integer.parseInt(paramQuantity);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@�w��̏��i�̒��������s���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@�����ɐ��������ꍇ�́A���i����������ʂ̃p�X��Ԃ��B
	 *           �����Ɏ��s�����ꍇ�́A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@�Z�b�V�������珤�i�ԍ��ƃ��O�C�����[�U�̏����A����Ɍ��݂�
	 *           ���������擾���A�����̏���check���\�b�h�Ŏ擾�ς݂�
	 *           ���ʂ����Ƃɒ��������쐬���Ē����e�[�u���֓o�^����B�o�^
	 *           �������͎���ʂŕK�v�ƂȂ邽�߃Z�b�V�����ɕۑ����A
	 *           ���i����������ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		ItemDTO item = (ItemDTO) session.getAttribute("item_dto");
		if (item == null) {
			return "/page/systemerror.jsp";
		}
		int itemNo = item.getNo();
		String itemName = item.getName();

		UserDTO user = (UserDTO) session.getAttribute("login_dto");
		if (user == null) {
			return "/page/systemerror.jsp";
		}
		int id = user.getId();

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		OrderDTO order =
			new OrderDTO(itemNo, itemName, quantity, id, timestamp);

		OrderDAO dao = new OrderDAO();
		int orderNo = dao.add(order);
		if (orderNo == -1) {
			return "/page/systemerror.jsp";
		}

		session.setAttribute("order_dto", order);

		return "/page/itemOrderComplete.jsp";
	}

}
