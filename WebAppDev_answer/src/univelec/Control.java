package univelec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import univelec.action.*;
import univelec.dao.DAOException;
import univelec.dto.UserDTO;

/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
/*
 * Model・JSPの実行制御をするクラス。
 * Copyright (c) NTT DATA UNIVERSITY CORPORATION
 */
public class Control extends HttpServlet {

	/* 
	 * 機　能：　ユーザが既にログインしているかを確認するためのメソッド。
	 *           セッションオブジェクトとセッション内にUserDTOがあれば
	 *           ログインしていると見なす。
	 * 
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 * 戻り値：　正しくセッションが生成されていればtrue、そうでなければfalseを返す。
	 * 解　説：　まずセッションオブジェクトの有無をチェックし、セッションがあれば
	 *           セッションから UserDTO の取得を試みる。これの取得ができれば
	 *           正しくログインされていると判断する。
	 */
	private boolean checkSession(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
			return false;
		}

		// UserDTOが取得できない(null)時にはログインしているとは見なさない。
		UserDTO user = (UserDTO) session.getAttribute("login_dto");
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * 機　能：　アクションを生成する。
	 *
	 * 引　数：　アクション名。
	 * 戻り値：　アクション。
	 * 解　説：　引数のアクション名に基づき、紐付くアクションを生成して
	 *           返却する。不明なアクション名はデフォルトのアクションを
	 *           生成して返却する。
	 */
	private Action createAction(String name) {
		if ("p001-login".equals(name)) {
			// ログインアクションを返却する。
			return new LoginAction();
		} else if ("p002-itemSearch".equals(name)) {
			// 商品一覧検索アクションを返却する。
			return new ItemListSearchAction();
		} else if ("p002-orderHistory".equals(name)) {
			// 注文履歴表示アクションを返却する。
			return new OrderSearchAction();
		} else if ("p002-orderSearch".equals(name)) {
			// 注文履歴ユーザコード入力アクションを返却する。
			return new OrderSearchConditionAction();
		} else if ("p002-userList".equals(name)) {
			// ユーザ情報一覧表示アクションを返却する。
			return new UserSearchAction();
		} else if ("p002-userAdd".equals(name)) {
			// ユーザ情報入力アクションを返却する。
			return new UserAddInputAction();
		} else if ("p002-syukei".equals(name)) {
			// TODO: 集計アクションを返却する。
		} else if ("p002-logout".equals(name)) {
			// ログアウトアクションを返却する。
			return new LogoutAction();
		} else if ("p101-select".equals(name)) {
			// 商品選択アクションを返却する。
			return new ItemSearchAction();
		} else if ("p102-order".equals(name)) {
			// 商品注文アクションを返却する。
			return new ItemOrderAction();
		} else if ("p201-select".equals(name)) {
			// 注文履歴表示アクションを返却する。
			return new OrderSearchOneAction();
		} else if ("p202-cancel".equals(name)) {
			// 注文キャンセルアクションを返却する。
			return new OrderCancelAction();
        } else if ("p211-search".equals(name)) {
        	// ユーザの注文履歴表示アクションを返却する。
            return new OrderSearchUserAction();
		} else if ("p301-select".equals(name)) {
			// ユーザ情報選択アクションを返却する。
			return new UserEditSearchAction();
		} else if ("p302-edit".equals(name)) {
			// ユーザ情報編集アクションを返却する。
			return new UserEditAction();
		} else if ("p302-delete".equals(name)) {
			// ユーザ情報削除アクションを返却する。
			return new UserDeleteAction();
		} else if ("p401-add".equals(name)) {
			// ユーザ情報追加アクションを返却する。
			return new UserAddAction();
		}

		//メニュー表示アクションを返却する。
		return new MenuAction();
	}

	/* 
	 * 機　能：　最初のリクエスト時にログイン画面を表示するメソッド。
	 * 
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 *           オーバーライドであるため、HttpServletResponseも受け取る。
	 * 解　説：　まずセッションオブジェクトの有無をチェックし、セッションがあれば
	 *           それを破棄する。その後ログイン画面に遷移する。
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		RequestDispatcher rd = req.getRequestDispatcher("/page/login.jsp");
		rd.forward(req, res);
	}

	/* 
	 * 機　能：　2度目以降のリクエストを処理するメソッド。
	 * 
	 * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
	 *           オーバーライドであるため、HttpServletResponseも受け取る。
	 * 解　説：　ログイン処理時以外はcheckSessionメソッドを呼び出し、ユーザの
	 *           ログイン状況を確認する。正常にログインしている場合は、ボタン名を
	 *           取得し、ボタン名に対応するModelクラスのオブジェクトを生成する。
	 *           生成したオブジェクトのcheckメソッドを呼び出して入力値の形式を
	 *           確認する。入力値の形式に問題が無ければexecuteメソッドを呼び出して
	 *           処理を実行する。executeメソッドは次に遷移すべきパスを返してくる
	 *           ので指定の遷移先に遷移する。
	 *           入力値の形式のエラーやexecuteメソッド実行時に例外が発生した場合は
	 *           セッションを切断し、エラー画面に遷移する。
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
		RequestDispatcher rd = null;
		String actionName = req.getParameter("action");

		if (!("p001-login".equals(actionName)) && checkSession(req) == false) {
			// セッションが無い、もしくは UserDTO が無いため、
			// 次の遷移先をエラー画面にする。
			rd = req.getRequestDispatcher("/page/loginerror.jsp");
		} else {
			// ボタン名から、実行するアクションを取得する。
			Action action = createAction(actionName);

			if (action.check(req)) {
				// パラメータのチェックがOKのため、処理を続行する。
				try {
					String path = action.execute(req);
					rd = req.getRequestDispatcher(path);
				} catch (DAOException e) {
					// 例外が発生したため、次の遷移先をエラー画面にする。
                    e.printStackTrace();
					rd = req.getRequestDispatcher("/page/dberror.jsp");
				}
			} else {
				// パラメータのチェックがNGのため、次の遷移先を
				// エラー画面にする。
				rd = req.getRequestDispatcher("/page/inputerror.jsp");
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.invalidate();
				}
			}
		}

		// 次の画面に遷移
		rd.forward(req, res);
	}
}
