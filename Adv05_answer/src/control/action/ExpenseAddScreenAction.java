package control.action;
import javax.servlet.http.*;
import control.dao.*;

public class ExpenseAddScreenAction implements Action {
	/*
	 * 機　能：　チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックする項目がないため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　経費情報登録画面に遷移するメソッド。
	 *
	 * 引　数：　Actionインタフェースの形式に従いリクエストを受け取る。
	 * 戻り値：　更新画面のパスを返す。
	 * 解　説：　実行する処理は存在せず、登録画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/html/expenseAdd.html";
	}
}