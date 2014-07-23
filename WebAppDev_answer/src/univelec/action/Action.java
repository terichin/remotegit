package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;

/*
 * Modelの形式を定義するインタフェース
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public interface Action {

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 */
	boolean check(HttpServletRequest req);

	/*
	 * 機　能：　アクション実行メソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　遷移先JSPのパス。
	 */
	String execute(HttpServletRequest req) throws DAOException;

}
