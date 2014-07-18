package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class AllUserSearchAction implements Action {
    /*
     * 機　能：　入力情報チェックメソッド。
     *
     * 引　数：　リクエストオブジェクト。
     * 戻り値：　常にtrueを返す。
     * 解　説：　チェックするパラメータは無いため、常にtrueを返す。
     */
    public boolean check(HttpServletRequest req) {
        // チェックするものが無いので常にtrueを返す
        return true;
    }

    /*
     * 機　能：　ユーザ情報の一覧を取得するメソッド。
     *
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     * 戻り値：　ユーザ情報一覧画面のパスを返す。
     * 解　説：　DBMSから登録されているユーザ情報一覧を取得する。取得した一覧は
     *　　　　　　次画面で必要となるためセッションに保存し、ユーザ情報一覧画面に遷移する。
     */
    public String execute(HttpServletRequest req) throws DAOException {
        NewEmployeeDAO dao = new NewEmployeeDAO();
        // DAOを使い、全件検索結果を取得する
        // ログインしての操作なため、検索結果が0件はあり得ない
        ArrayList<EmployeeDTO> list = dao.searchAllUser();
        HttpSession session = req.getSession(false);
        // 取得した全件検索結果をセッションに格納し、JSPで表示する
        session.setAttribute("emp_list", list);
        return "/page/userSearch.jsp";
    }
}

