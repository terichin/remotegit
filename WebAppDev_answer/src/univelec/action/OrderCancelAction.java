package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 注文を取り消すクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class OrderCancelAction implements Action {

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックする項目は無いため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　指定の注文情報を削除するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　キャンセルが成功した場合は、注文キャンセル完了画面のパスを返す。
	 *           キャンセルが失敗した場合は、エラー画面のパスを返す。
	 * 解　説：　セッションから前画面で指定された注文情報を取得し、注文情報に
	 *           指定された番号の注文を削除する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		OrderDTO dto = (OrderDTO) session.getAttribute("order_dto");
		if (dto == null) {
			// キャンセル対象の注文情報が見つからないのでエラー画面へ遷移する。
			return "/page/systemerror.jsp";
		}

		OrderDAO dao = new OrderDAO();
		int result = dao.delete(dto.getNo());
		if (result != 1) {
			// キャンセルに失敗したのでエラー画面へ遷移。
			return "/page/systemerror.jsp";
		}

		return "/page/orderCancelComplete.jsp";
	}

}
