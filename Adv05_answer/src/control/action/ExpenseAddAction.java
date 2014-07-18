package control.action;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class ExpenseAddAction implements Action {
	private Date usedate;		// ���t
	private String use;			// �p�r
	private int cost;			// ��p

	/*
	 * �@�@�\�F�@���͏��`�F�b�N���\�b�h�B
	 *
	 * ���@���F�@���N�G�X�g�I�u�W�F�N�g�B
	 * �߂�l�F�@���͒l���������`���ł����true�A����ȊO��false��Ԃ��B
	 * ���@���F�@���͂��ꂽ�o����̊e���e���`�F�b�N����B
	 */
	public boolean check(HttpServletRequest req) {
		// ���t�̃`�F�b�N
		String usedate = req.getParameter("usedate");
		if ((usedate == null) || ("".equals(usedate) == true)) {
			return false;
		}
		try {
			java.util.Date date = DateFormat.getDateInstance().parse(usedate);
			this.usedate = new Date(date.getTime());
		} catch (ParseException e) {
			return false;
		}
		// �p�r�̃`�F�b�N
		use = req.getParameter("use");
		if ((use == null) || ("".equals(use) == true)) {
			return false;
		}
		// ��p�̃`�F�b�N
		String paramCost = req.getParameter("cost");
		if ((paramCost == null) || ("".equals(paramCost))) {
			return false;
		}
		try {
			cost = Integer.parseInt(paramCost);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/*
	 * �@�@�\�F�@�o����̓o�^�����s���郁�\�b�h�B
	 *
	 * ���@���F�@�Z�b�V�������擾����K�v������̂ŁAHttpServletRequest���󂯎��B
	 * �߂�l�F�@�o����̓o�^�ɐ��������ꍇ�́A�o����ǉ�������ʂ̃p�X��Ԃ��B
	 *           �o����̓o�^�Ɏ��s�����ꍇ�́A�G���[��ʂ̃p�X��Ԃ��B
	 * ���@���F�@���͂��ꂽ�p�����[�^�������o�ϐ�����擾�A�X�ɃZ�b�V�������烆�[�U����
	 *           �擾���A����2�̏����g�p����DTO�𐶐����AExpenseDAO�̃��\�b�h�ɍ쐬
	 *           ����DTO��n���Čo�����o�^����B�o�^�����o����͎���ʂ̕\���ŕK�v
	 *           �ƂȂ邽�߃Z�b�V�����ɕۑ����A�o����ǉ�������ʂɑJ�ڂ���B
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		EmployeeDTO emp = (EmployeeDTO) session.getAttribute("login_dto");
		ExpenseDTO dto = new ExpenseDTO(-1, emp.getId(), usedate, use, cost);
		NewExpenseDAO dao = new NewExpenseDAO();
		int result = dao.addExpense(dto);
		if (result != 1) {
			return "/html/dberror.html";
		}
		session.setAttribute("expense_dto", dto);

		return "/page/expenseAddComplete.jsp";
	}
}