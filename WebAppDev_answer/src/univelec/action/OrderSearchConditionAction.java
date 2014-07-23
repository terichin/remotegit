package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * 注文履歴検索画面遷移アクションクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchConditionAction implements Action {

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
	 * 機　能：　注文履歴検索画面に遷移するメソッド。
	 *
	 * 引　数：　Actionインタフェースの形式に従いリクエストを受け取る。
	 * 戻り値：　検索条件入力画面のパスを返す。
	 * 解　説：　実行する処理は存在せず、検索条件入力画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		return "/page/orderSearch.jsp";
	}

}
