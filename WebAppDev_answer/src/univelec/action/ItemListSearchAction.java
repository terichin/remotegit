package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 商品一覧を取得するクラス
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemListSearchAction implements Action {

	private int category; // カテゴリコード

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力されたカテゴリがnullまたは空文字でないかチェックする。
	 */
	public boolean check(HttpServletRequest req) {
		// カテゴリコードのチェック
		String paramCategory = req.getParameter("category");
		if ((paramCategory == null) || ("".equals(paramCategory))) {
			return false;
		}
		try {
			category = Integer.parseInt(paramCategory);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * 機　能：　商品情報一覧を取得するメソッド
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　商品一覧画面のパスを返す。
	 * 解　説：　カテゴリコードに紐付く商品情報の一覧を取得し、商品一覧画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemDTO> list = dao.getItemList(category);

		HttpSession session = req.getSession(false);
		session.setAttribute("item_list", list);

		return "/page/itemList.jsp";
	}

}
