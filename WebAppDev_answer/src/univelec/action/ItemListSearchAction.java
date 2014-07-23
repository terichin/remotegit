package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ���i�ꗗ���擾����N���X
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemListSearchAction implements Action {

	private int category; // �J�e�S���R�[�h

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ�J�e�S����null�܂��͋󕶎��łȂ����`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// �J�e�S���R�[�h�̃`�F�b�N
		String paramCategory = req.getParameter("category");
		if ((paramCategory == null) || ("".equals(paramCategory))) {
			return false;
		}
		try {
			category = Integer.parseInt(paramCategory);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * �@�@�\�F�@���i���ꗗ���擾���郁�\�b�h
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@���i�ꗗ��ʂ̃p�X��Ԃ��B
	 * ���@���F�@�J�e�S���R�[�h�ɕR�t�����i���̈ꗗ���擾���A���i�ꗗ��ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemDTO> list = dao.getItemList(category);

		HttpSession session = req.getSession(false);
		session.setAttribute("item_list", list);

		return "/page/itemList.jsp";
	}

}
