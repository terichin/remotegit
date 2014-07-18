package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.action.*;
import control.dao.DAOException;
import control.dto.EmployeeDTO;

/**
 * Servlet implementation class Control
 */
@WebServlet("/control")
public class Control extends HttpServlet {
    /* 
     * 機　能：　最初のリクエスト時にログイン画面を表示するメソッド。
     * 
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     *　　　　　　オーバーライドであるため、HttpServletResponseも受け取る。
     * 解　説：　まずセッションオブジェクトの有無をチェックし、セッションがあれば
     *　　　　　　それを破棄する。その後ログイン画面に遷移する。
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/html/login.html");
        rd.forward(req, res);
    }
    
    /* 
     * 機　能：　2度目以降のリクエストを処理するメソッド。
     * 
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     *　　　　　　オーバーライドであるため、HttpServletResponseも受け取る。
     * 解　説：　リクエスト元を確認し、ログイン画面からの要求だった場合は、
     *　　　　　　LoginActionオブジェクトを生成し、check()メソッドとexecute()
     *　　　　　　メソッドを呼び出す。何らかの処理が失敗した場合はエラー画面へ
     *　　　　　　遷移する。
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        req.setCharacterEncoding("Windows-31J");
        RequestDispatcher rd = null;
        String actionName = req.getParameter("action");

        // 画面識別IDに応じたアクションを実行する
        if (!(actionName.equals("login")) && checkSession(req) == false) {
            // ログイン画面ではなく、このシステムのログイン条件を満たしていない時は
            // 次の遷移先をエラー画面にする。
            rd = req.getRequestDispatcher("/html/systemerror.html");
        } else {
            Action action = createAction(actionName);
            if (action != null) {
                try {
                    if (action.check(req)) {
                        // 入力値のチェックがOKのため、処理の実行を行う。
                        String path = action.execute(req);
                        rd = req.getRequestDispatcher(path);
                    } else {
                        rd = req.getRequestDispatcher("/html/checkerror.html");
                    }
                } catch (DAOException e) {
                    e.printStackTrace();
                    rd = req.getRequestDispatcher("/html/dberror.html");
                }
            } else {
                // 論理的にあり得ないが、保険として追加する
                rd = req.getRequestDispatcher("/html/systemerror.html");
            }
        }
        rd.forward(req, res);
    }
    
    /* 
     * 機　能：　ユーザが既にログインしているかを確認するためのメソッド。
     *　　　　　　セッションオブジェクトとセッション内にUserDTOがあれば
     *　　　　　　ログインしていると見なす。
     * 
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     * 戻り値：　正しくセッションが生成されていればtrue、そうでなければfalseを返す。
     * 解　説：　まずセッションオブジェクトの有無をチェックし、セッションがあれば
     *　　　　　　セッションから EmployeeDTO の取得を試みる。これの取得ができれば
     *　　　　　　正しくログインされていると判断する。
     */
    private boolean checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        // EmployeeDTOが取得できない時にはログインしているとは見なさない。
        EmployeeDTO user = (EmployeeDTO) session.getAttribute("login_dto");
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
     *　　　　　　返却する。不明なアクション名はデフォルトのアクションを
     *　　　　　　生成して返却する。
     */
    private Action createAction(String name) {
        if ("login".equals(name)) {
            // ログインアクションを返却します
            return new LoginAction();
        } else if ("search".equals(name)) {
            // ユーザ登録画面表示アクションを返却します
            return new UserSearchScreenAction();
        } else if ("searchone".equals(name)) {
            // ユーザ登録画面表示アクションを返却します
            return new UserSearchAction();
        } else if ("add".equals(name)) {
            // ユーザ登録画面表示アクションを返却します
            return new UserAddScreenAction();
        } else if ("regist".equals(name)) {
            // ユーザ登録アクションを返却します
            return new UserAddAction();
        } else if ("update".equals(name)) {
            // ユーザ更新検索画面アクションを返却します
            return new UserUpdateScreenAction();
        } else if ("updatesearch".equals(name)) {
            // ユーザ更新検索アクションを返却します
            return new UserUpdateSearchAction();
        } else if ("renew".equals(name)) {
            // ユーザ更新アクションを返却します
            return new UserUpdateAction();
        } else if ("expenseadd".equals(name)) {
        	// 経費登録画面表示アクションを返却します
        	return new ExpenseAddScreenAction();
        } else if ("expenseregist".equals(name)) {
     	    // 経費登録アクションを返却します
     	    return new ExpenseAddAction();
     	} else if ("searchall".equals(name)) {
            // ユーザ全件検索アクションを返却します
            return new AllUserSearchAction();
        } else if ("searchallcontact".equals(name)) {
            // 電話番号全件検索アクションを返却します
            return new AllContactSearchAction(); 
        } else if ("searchexpense".equals(name)) {
            // 経費検索画面表示アクションを返却します
            return new ExpenseSearchScreenAction();
        } else if ("searchexpense2".equals(name)) {
            // 経費検索画面表示アクションを返却します
            return new ExpenseSearchScreenAction2();
        } else if ("searchexpenseuser".equals(name)) {
            // 経費検索アクションを返却します
            return new ExpenseSearchAction(); 
        } else if ("searchexpenseuser2".equals(name)) {
            // 経費検索アクションを返却します
            return new ExpenseSearchAction2(); 
        } else if ("searchemployee".equals(name)) {
            // ユーザ情報検索画面表示アクションを返却します
            return new EmployeeInfoSearchScreenAction();
        } else if ("searchemployeeid".equals(name)) {
            // ユーザ情報検索アクションを返却します
            return new EmployeeInfoSearchAction();
        } else if ("logout".equals(name)) {
            // ログアウトアクションを返却します
            return new LogoutAction();
        }
        //（どの条件にも一致しなかった場合は）メニューアクションを返却します
        return new MenuAction();
    }
}