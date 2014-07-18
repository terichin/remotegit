package control.action;
import java.text.*;
import java.sql.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class ExpenseAddAction implements Action {
	private Date usedate;		// 日付
	private String use;			// 用途
	private int cost;			// 費用

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力された経費情報の各内容をチェックする。
	 */
	public boolean check(HttpServletRequest req) {
		// 日付のチェック
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
		// 用途のチェック
		use = req.getParameter("use");
		if ((use == null) || ("".equals(use) == true)) {
			return false;
		}
		// 費用のチェック
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
	 * 機　能：　経費情報の登録を実行するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　経費情報の登録に成功した場合は、経費情報追加完了画面のパスを返す。
	 *           経費情報の登録に失敗した場合は、エラー画面のパスを返す。
	 * 解　説：　入力されたパラメータをメンバ変数から取得、更にセッションからユーザ情報を
	 *           取得し、その2つの情報を使用してDTOを生成し、ExpenseDAOのメソッドに作成
	 *           したDTOを渡して経費情報を登録する。登録した経費情報は次画面の表示で必要
	 *           となるためセッションに保存し、経費情報追加完了画面に遷移する。
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