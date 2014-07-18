package control.action;
import javax.servlet.http.*;
import control.dao.*;

public class MenuAction2 implements Action {

	/*
	 * 機　能：　チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックを行うパラメータは無いため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　メニュー画面への遷移を実行するメソッド。
	 *
	 * 引　数：　Actionインタフェースの形式に従いリクエストを受け取る。
	 * 戻り値：　メニュー画面のパスを返す。
	 * 解　説：　メニュー画面へ遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/html/menu2.html";
	}

}
