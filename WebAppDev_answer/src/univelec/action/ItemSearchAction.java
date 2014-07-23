package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 商品情報を取得するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemSearchAction implements Action {

	private int itemNo; // 商品番号

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力された商品番号がnullまたは空文字でないかチェックする。
	 */
	public boolean check(HttpServletRequest req) {
		// 商品番号のチェック
		String paramItemNo = req.getParameter("itemNo");
		if ((paramItemNo == null) || ("".equals(paramItemNo))) {
			return false;
		}
		try {
			itemNo = Integer.parseInt(paramItemNo);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * 機　能：　番号で指定された商品情報を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　商品情報が取得できた場合は、商品注文画面のパスを返す。
	 *           商品情報が取得できなかった場合は、エラー画面のパスを返す。
	 * 解　説：　商品情報をDBMSから取得するためのDAOオブジェクトを生成し、
	 *           商品番号に紐付く商品情報を取得する。取得した商品情報は次画面で
	 *           表示するためセッションに保存して商品注文画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		ItemDAO dao = new ItemDAO();
		ItemDTO item = dao.getItem(itemNo);
		if (item == null) {
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("item_dto", item);

		return "/page/itemOrder.jsp";
	}

}
