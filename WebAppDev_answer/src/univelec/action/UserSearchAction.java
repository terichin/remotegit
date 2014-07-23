package univelec.action;
import java.util.*;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ユーザの一覧を取得するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserSearchAction implements Action {

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックするパラメータは無いため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　ユーザ情報の一覧を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受取る。
	 * 戻り値：　ユーザ情報一覧画面のパスを返す。
	 * 解　説：　DBMSから登録されているユーザ情報一覧をを取得する。取得した一覧
	 *           は次画面で必要となるためセッションに保存し、ユーザ情報一覧画面
	 *           に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDAO dao = new UserDAO();
		ArrayList<UserDTO> list = dao.getUserList();

		HttpSession session = req.getSession(false);
		session.setAttribute("user_list", list);

		return "/page/userSearch.jsp";
	}
}
