package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 注文番号と紐付く注文情報を取得するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderSearchOneAction implements Action {

	private int orderNo; // 注文番号

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力される注文番号に対してnullチェックと数値チェックを行う。
	 */
	public boolean check(HttpServletRequest req) {
		// 注文番号のチェック
		String paramNo = req.getParameter("no");
		if ((paramNo == null) || ("".equals(paramNo) == true)) {
			return false;
		}
		try {
			orderNo = Integer.parseInt(paramNo);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/*
	 * 機　能：　指定された注文番号の注文情報を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　注文情報を取得できれば、注文キャンセル画面のパスを返す。
	 *           注文情報を取得できなければ、エラー画面のパスを返す。
	 * 解　説：　入力された注文番号を使用してDBMSから注文情報を取得する。
	 *           注文情報は次画面の表示やその後のキャンセル処理で使用するため
	 *           セッションに保存し、注文キャンセル画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		OrderDAO dao = new OrderDAO();
		OrderDTO dto = dao.getOrder(orderNo);
		if (dto == null) {
			// 指定の番号の注文情報が見つからないのでエラー画面に遷移。
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("order_dto", dto);

		return "/page/orderCancel.jsp";
	}

}
