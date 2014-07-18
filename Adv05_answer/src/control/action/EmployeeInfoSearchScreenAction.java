package control.action;
import javax.servlet.http.*;
import control.dao.*;

public class EmployeeInfoSearchScreenAction implements Action {
	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックする項目は存在しないため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　ユーザ情報検索画面への遷移を実行するメソッド。
	 *
	 * 引　数：　Actionインタフェースの形式に従いリクエストを受け取る。
	 * 戻り値：　ユーザ情報検索画面のパスを返す。
	 * 解　説：　ユーザ情報検索画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/html/employeeSearch.html";
	}
}