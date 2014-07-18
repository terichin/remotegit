package control.action;
import javax.servlet.http.*;
import control.dao.*;

public class LogoutAction implements Action {
    /*
     * 機　能：　入力情報チェックメソッド。
     *
     * 引　数：　リクエストオブジェクト。
     * 戻り値：　常にtrueを返す。
     * 解　説：　チェックするパラメータは無いので、常にtrueを返す。
     */
    public boolean check(HttpServletRequest req) {
        // チェックするものが無いので常にtrueを返す
        return true;
    }

    /*
     * 機　能：　ログアウト処理を実行するメソッド。
     *
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     * 戻り値：　ログイン画面のパスを返す。
     * 解　説：　セッションを破棄してログイン画面に遷移する。
     */
    public String execute(HttpServletRequest req) throws DAOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            // セッション自体を破棄する
            session.invalidate();
        }
        return "/html/login.html";
    }
}