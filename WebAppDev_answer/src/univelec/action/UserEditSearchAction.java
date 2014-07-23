package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * 編集対象のユーザ情報を取得するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserEditSearchAction implements Action {

	private int userId; // 編集対象ユーザコード

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力されたユーザコードがnullまたは空文字かどうかをチェックする。
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
	 * 機　能：　更新対象のユーザ情報を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受取る。
	 * 戻り値：　ユーザ情報の取得に成功した場合はユーザ情報編集画面のパスを返す。
	 *           ユーザ情報の取得に失敗した場合はエラー画面のパスを返す。
	 * 解　説：　入力されたユーザコードに紐付くユーザ情報を取得する。取得した
	 *           ユーザ情報は次画面で必要となるためセッションに保存し、
	 *           ユーザ情報編集画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.getUser(userId);
		if (dto == null) {
			// 指定のユーザ情報の取得に失敗したのでエラー画面に遷移。
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("user_dto", dto);

		return "/page/userEdit.jsp";
	}

}
