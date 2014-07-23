package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���i�����擾����N���X�B
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemSearchAction implements Action {

	private int itemNo; // ���i�ԍ�

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ���i�ԍ���null�܂��͋󕶎��łȂ����`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// ���i�ԍ��̃`�F�b�N
		String paramItemNo = req.getParameter("itemNo");
		if ((paramItemNo == null) || ("".equals(paramItemNo))) {
			return false;
		}
		try {
			itemNo = Integer.parseInt(paramItemNo);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@�ԍ��Ŏw�肳�ꂽ���i�����擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���i��񂪎擾�ł����ꍇ�́A���i������ʂ̃p�X��Ԃ��B
	 *           ���i��񂪎擾�ł��Ȃ������ꍇ�́A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���i����DBMS����擾���邽�߂�DAO�I�u�W�F�N�g�𐶐����A
	 *           ���i�ԍ��ɕR�t�����i�����擾����B�擾�������i���͎���ʂ�
	 *           �\�����邽�߃Z�b�V�����ɕۑ����ď��i������ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		ItemDAO dao = new ItemDAO();
		ItemDTO item = dao.getItem(itemNo);
		if (item == null) {
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("item_dto", item);

		return "/page/itemOrder.jsp";
	}

}
