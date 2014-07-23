package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ユーザ情報を編集するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserEditAction implements Action {

	private int userId; // ユーザコード
	private String kana; // かな
	private String mail; // メールアドレス
	private String name; // 名前
	private String phone; // 電話番号
	private String password; // パスワード
	private int privilege; // 権限

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力されたユーザ情報の各編集内容をチェックする。
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

		// 名前のチェック
		name = req.getParameter("name");
		if ((name == null) || ("".equals(name) == true)) {
			return false;
		}

		// かなのチェック
		kana = req.getParameter("kana");
		if ((kana == null) || ("".equals(kana) == true)) {
			return false;
		}

		// 電話番号のチェック
		phone = req.getParameter("phone");
		if ((phone == null) || ("".equals(phone) == true)) {
			return false;
		}

		// メールアドレスのチェック
		mail = req.getParameter("mail");
		if ((mail == null) || ("".equals(mail) == true)) {
			return false;
		}

		// パスワードのチェック
		password = req.getParameter("password");
		if ((password == null) || ("".equals(password) == true)) {
			return false;
		}

		// ユーザ権限のチェック
		String paramPrivilege = req.getParameter("privilege");
		if ((paramPrivilege == null) || ("".equals(paramPrivilege) == true)) {
			// チェックボックスがチェックされていなければ、情報は送信されない。
			privilege = 0;
		} else {
			privilege = 1;
		}

		return true;
	}

	/*
	 * 機　能：　ユーザ情報の更新を実行するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　ユーザ情報更新成功の場合はユーザ情報編集完了画面のパスを返す。
	 *           ユーザ情報更新失敗の場合はエラー画面のパスを返す。
	 * 解　説：　入力されたパラメータを使用してDTOオブジェクトを生成し、
	 *           UserDAOのメソッドにDTOを渡してユーザ情報を更新する。
	 *           更新に使用した情報は次画面で必要となるためセッションに保存し、
	 *           ユーザ情報編集完了画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDTO dto =
			new UserDTO(userId, name, kana, phone, mail, password, privilege);

		UserDAO dao = new UserDAO();
		int result = dao.edit(dto);
		if (result != 1) {
			// ユーザ情報更新に失敗したのでエラー画面に遷移する。
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("user_dto", dto);

		return "/page/userEditComplete.jsp";
	}

}
