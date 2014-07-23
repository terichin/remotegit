package univelec.action;
import javax.servlet.http.*;
import univelec.dao.*;
import univelec.dto.*;

/*
 * ユーザ情報を削除するクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class UserDeleteAction implements Action {

	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　常にtrueを返す。
	 * 解　説：　チェックする項目は存在しないため、常にtrueを返す。
	 */
	public boolean check(HttpServletRequest req) {
		return true;
	}

	/*
	 * 機　能：　ユーザ情報の削除を実行するメソッド。
	 *
	 * 引　数：　Actionインタフェースの形式に従いリクエストを受け取る。
	 * 戻り値：　ユーザ情報削除成功時は、ユーザ情報削除完了画面のパスを返す。
	 *           ユーザ情報削除失敗時は、エラー画面のパスを返す。
	 * 解　説：　セッションから先の画面で選択されたユーザ情報を取得し、
	 *           指定されたユーザのユーザコードを取得してDAOのユーザ削除メソッドを
	 *           呼び出す。削除が成功したらユーザ情報削除完了画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		HttpSession session = req.getSession(false);
		UserDTO dto = (UserDTO) session.getAttribute("user_dto");
		if (dto == null) {
			// 指定のユーザ情報の取得に失敗したのでエラー画面に遷移。
			return "/page/systemerror.jsp";
		}
		int id = dto.getId();
		
		UserDAO dao = new UserDAO();
		int result = dao.delete(id);
		if (result != 1) {
			// ユーザ情報の削除に失敗したためエラー画面に遷移する。
			return "/page/systemerror.jsp";
		}

		return "/page/userDeleteComplete.jsp";
	}

}
