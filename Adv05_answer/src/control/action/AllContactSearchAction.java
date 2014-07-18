package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class AllContactSearchAction implements Action {
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
	 * 機　能：　電話番号情報の一覧を取得するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　電話番号情報一覧画面のパスを返す。
	 * 解　説：　DBMSから登録されている電話番号情報一覧を取得する。取得した一覧は
	 *           次画面で必要となるためセッションに保存し、電話番号情報一覧画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		NewContactDAO dao = new NewContactDAO();
		ArrayList<ContactDTO> list = dao.getContactList();
		HttpSession session = req.getSession(false);
		session.setAttribute("contact_list", list);
		return "/page/contactSearch.jsp";
	}
}