package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class ExpenseSearchAction implements Action {
	private int empId;			// ユーザコード

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力されるユーザコードに対してnullチェックと数値チェックを行う。
	 */
	public boolean check(HttpServletRequest req) {
		// ユーザコードのチェック
		String paramId = req.getParameter("EMPID");
		if ((paramId == null) || ("".equals(paramId))) {
			return false;
		}
		try {
			empId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/*
	 * 機　能：　指定されたユーザコードの経費情報を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　経費情報を取得できれば、検索結果画面のパスを返す。
	 *           経費情報を取得できなければ、エラー画面のパスを返す。
	 * 解　説：　入力されたユーザコードを使用してDBMSから経費情報を取得する。
	 *           経費情報は次画面の表示で使用するためセッションに保存する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		NewExpenseDAO dao = new NewExpenseDAO();
		ArrayList<ExpenseDTO> list = dao.getExpenseList(empId);
		HttpSession session = req.getSession(false);
		session.setAttribute("expense_list", list);
		return "/page/expenseSearch.jsp";
	}
}