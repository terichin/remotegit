package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 指定されたユーザの注文履歴を取得するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchUserAction implements Action {

	private int userId; // ユーザコード

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力されるユーザコードに対してnullチェックと数値チェックを行う。
	 */
	public boolean check(HttpServletRequest req) {
		// ユーザコードのチェック
		String paramId = req.getParameter("id");
		if ((paramId == null) || ("".equals(paramId) == true)) {
			return false;
		}
		try {
			userId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * 機　能：　指定のユーザの注文履歴情報を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　注文履歴表示画面のパスを返す。
	 * 解　説：　checkメソッドで取得したユーザコードを使用し、指定のユーザが行った
	 *           注文の履歴情報を取得する。次画面ではユーザコードと注文履歴情報が
	 *           必要であるため、セッションにそれらを保存し注文履歴表示画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		OrderDAO dao = new OrderDAO();
		ArrayList<OrderDTO> list = dao.getOrderList(userId);

		HttpSession session = req.getSession(false);
		session.setAttribute("order_id", userId);
		session.setAttribute("order_list", list);

		return "/page/orderSearchResult.jsp";
	}

}
