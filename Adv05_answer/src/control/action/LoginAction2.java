package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class LoginAction2 implements Action {
	private int empId;			// ユーザコード
	private String password;	// パスワード
	
	/*
	 * 機　能：　入力情報チェックメソッド。
	 *
	 * 引　数：　リクエストオブジェクト。
	 * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
	 * 解　説：　入力されたユーザコードとパスワードがnullまたは空文字でないか
	 *           チェックする。
	 */
	public boolean check(HttpServletRequest req) {
		// ユーザコードのチェック
		String paramId = req.getParameter("EMPID");
		if ((paramId == null) || ("".equals(paramId))) {
			return false;
		}
		try {
			empId = Integer.parseInt(paramId);
		} catch (NumberFormatException e) {
			return false;
		}
		// パスワードのチェック
		password = req.getParameter("PASSWORD");
		if ((password == null) || ("".equals(password))) {
			return false;
		}
		return true;
	}
	
	/*
	 * 機　能：　ログイン処理を実行するメソッド。
	 *
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　ログイン成功時にはメニュー画面のパスを返す。
	 *           ログイン失敗時にはエラー画面のパスを返す。
	 * 解　説：　入力されたユーザコードとパスワードを使用して、入力された情報が
	 *           DBMSに登録されていることを確認する。情報がDBMSに登録されていれば
	 *           正しいユーザとみなしてセッションを生成し、入力されたユーザ情報を
	 *           セッションに保存してメニュー画面に遷移する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		EmployeeDTO emp = new EmployeeDTO(empId, "", password);
		NewEmployeeDAO dao = new NewEmployeeDAO();
		if (dao.checkLogin(emp) == true) {
			// ログインに成功したのでセッションを生成し、ユーザ情報を登録します
			HttpSession session = req.getSession(true);
			session.setAttribute("login_dto", emp);

			return "/html/menu2.html";
		} else {
			// ユーザ認証に失敗したのでエラー画面へ
			return "/html/loginerror.html";
		}
	}
}
