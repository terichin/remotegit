package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ユーザ情報を追加するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserAddAction implements Action {

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
	 * 解　説：　入力されたユーザ情報の各内容をチェックする。
	 */
	public boolean check(HttpServletRequest req) {
		// ユーザコードのチェック
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
	 * 機　能：　ユーザ情報の登録を実行するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受取る。
	 * 戻り値：　ユーザ情報の登録成功の場合は、ユーザ情報追加完了画面のパスを返す。
	 *           ユーザ情報の登録失敗の場合は、エラー画面のパスを返す。
	 * 解　説：　入力されたパラメータをメンバ変数から取得してDTOを生成し、UserDAOの
	 *           メソッドに作成したDTOを渡してユーザ情報を登録する。登録したユーザ
	 *           情報は次画面の表示で必要となるためセッションに保存し、ユーザ情報
	 *           追加完了画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		UserDTO dto = 
			new UserDTO(name, kana, phone, mail, password, privilege);

		UserDAO dao = new UserDAO();
		int result = dao.add(dto);
		if (result != 1) {
			// ユーザ情報追加に失敗したので、エラー画面に遷移する。
			return "/page/systemerror.jsp";
		}

		HttpSession session = req.getSession(false);
		session.setAttribute("user_dto", dto);

		return "/page/userAddComplete.jsp";
	}

}
