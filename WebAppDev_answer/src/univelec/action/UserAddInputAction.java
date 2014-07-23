package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * ユーザ情報追加画面に遷移するだけのクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserAddInputAction implements Action {

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
	 * 機　能：　ユーザ情報追加画面への遷移を実行するメソッド。
	 *
	 * 引　数：　Actionインタフェースの形式に従いリクエストを受け取る。
	 * 戻り値：　ユーザ情報追加画面のパスを返す。
	 * 解　説：　ユーザ情報追加画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/page/userAdd.jsp";
	}

}
