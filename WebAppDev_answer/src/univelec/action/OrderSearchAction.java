package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 注文検索アクション
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchAction implements Action {

	/*
	 * 機　能：　チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックするパラメータが存在しないため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　ログインユーザの注文履歴情報を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　注文履歴表示画面のパスを返す。
	 * 解　説：　セッションからログインユーザの情報を取得し、ログインユーザが行った
	 *           注文の履歴情報を取得する。次画面ではユーザコードと注文履歴情報が
	 *           必要であるため、セッションにそれらを保存し注文履歴表示画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		UserDTO user = (UserDTO) session.getAttribute("login_dto");
		int id = user.getId();

		OrderDAO dao = new OrderDAO();
		ArrayList<OrderDTO> list = dao.getOrderList(id);

		session.setAttribute("order_id", id);
		session.setAttribute("order_list", list);

		return "/page/orderSearchResult.jsp";
	}

}
