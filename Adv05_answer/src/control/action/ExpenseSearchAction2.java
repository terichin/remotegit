package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class ExpenseSearchAction2 implements Action {
	private int empId;			// ���[�U�R�[�h
	private int year;			// �Ώ۔N
	private int month;			// �Ώی�

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂���郆�[�U�R�[�h�E�N�E���ɑ΂���null�`�F�b�N�Ɛ��l�`�F�b�N���s���B
	 */
	public boolean check(HttpServletRequest req) {
		// ���[�U�R�[�h�̃`�F�b�N
		String paramId = req.getParameter("EMPID");
		if ((paramId == null) || ("".equals(paramId))) {
			return false;
		}
		try {
			empId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}
		// �Ώ۔N�̃`�F�b�N
		String paramYear = req.getParameter("year");
		if ((paramYear == null) || ("".equals(paramYear))) {
			return false;
		}
		try {
			year = Integer.parseInt(paramYear);
		} catch (NumberFormatException e) {
			return false;
		}
		// �Ώی��̃`�F�b�N
		String paramMonth = req.getParameter("month");
		if ((paramMonth == null) || ("".equals(paramMonth))) {
			return false;
		}
		try {
			month = Integer.parseInt(paramMonth);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/*
	 * �@�@�\�F�@�w�肳�ꂽ���[�U�R�[�h�E�N�E���̌o������擾���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@�o������擾�ł���΁A�������ʉ�ʂ̃p�X��Ԃ��B
	 *           �o������擾�ł��Ȃ���΁A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ���[�U�R�[�h�E�N�E�����g�p����DBMS����o������擾����B
	 *           �o����͎���ʂ̕\���Ŏg�p���邽�߃Z�b�V�����ɕۑ�����B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		NewExpenseDAO dao = new NewExpenseDAO();
		ArrayList<ExpenseDTO> list = dao.getExpenseList(empId, year, month);
		HttpSession session = req.getSession(false);
		session.setAttribute("expense_list", list);
		return "/page/expenseSearch2.jsp";
	}
}