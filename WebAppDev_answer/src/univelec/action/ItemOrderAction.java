package univelec.action;
import java.sql.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 商品を注文するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class ItemOrderAction implements Action {

	private int quantity; // 数量

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力された数量がnullまたは空文字でないことをチェックする。
	 */
	public boolean check(HttpServletRequest req) {
		// 数量のチェック
		String paramQuantity = req.getParameter("quantity");
		if ((paramQuantity == null) || ("".equals(paramQuantity))) {
			return false;
		}
		try {
			quantity = Integer.parseInt(paramQuantity);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * 機　能：　指定の商品の注文を実行するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　注文に成功した場合は、商品注文完了画面のパスを返す。
	 *           注文に失敗した場合は、エラー画面のパスを返す。
	 * 解　説：　セッションから商品番号とログインユーザの情報を、さらに現在の
	 *           時刻情報を取得し、これらの情報とcheckメソッドで取得済みの
	 *           数量をもとに注文情報を作成して注文テーブルへ登録する。登録
	 *           した情報は次画面で必要となるためセッションに保存し、
	 *           商品注文完了画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		ItemDTO item = (ItemDTO) session.getAttribute("item_dto");
		if (item == null) {
			return "/page/systemerror.jsp";
		}
		int itemNo = item.getNo();
		String itemName = item.getName();

		UserDTO user = (UserDTO) session.getAttribute("login_dto");
		if (user == null) {
			return "/page/systemerror.jsp";
		}
		int id = user.getId();

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		OrderDTO order =
			new OrderDTO(itemNo, itemName, quantity, id, timestamp);

		OrderDAO dao = new OrderDAO();
		int orderNo = dao.add(order);
		if (orderNo == -1) {
			return "/page/systemerror.jsp";
		}

		session.setAttribute("order_dto", order);

		return "/page/itemOrderComplete.jsp";
	}

}
