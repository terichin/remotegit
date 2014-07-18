package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class UserAddAction implements Action {
    private String name;     // 名前
    private String password; // パスワード

    /*
     * 機　能：　入力情報チェックメソッド。
     *
     * 引　数：　リクエストオブジェクト。
     * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
     * 解　説：　入力されたユーザ情報の各内容をチェックする。
     */
    public boolean check(HttpServletRequest req) {
        // 氏名のチェック
        name = req.getParameter("name");
        if ((name == null) || (name.equals("") == true)) {
            return false;
        }
        // パスワードのチェック
        password = req.getParameter("password");
        if ((password == null) || (password.equals("") == true)) {
            return false;
        }
        return true;
    }

    /*
     * 機　能：　ユーザ情報の登録を実行するメソッド。
     *
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     * 戻り値：　ユーザ情報の登録に成功した場合は、ユーザ情報追加完了画面のパスを返す。
     *　　　　　　ユーザ情報の登録に失敗した場合は、エラー画面のパスを返す。
     * 解　説：　入力されたパラメータをメンバ変数から取得してDTOを生成し、EmployeeDAOの
     *　　　　　　メソッドに作成したDTOを渡してユーザ情報を登録する。登録したユーザ情報は
     *　　　　　　次画面の表示で必要となるためセッションに保存し、ユーザ情報追加完了画面に
     *　　　　　　遷移する。
     */
    public String execute(HttpServletRequest req) throws DAOException {
        // ユーザコードは後で採番するため、取り敢えず-1を入れた
        // 入力情報を持つEmployeeDTOを作成する
        EmployeeDTO dto = new EmployeeDTO(-1, name, password);
        NewEmployeeDAO dao = new NewEmployeeDAO();
        int result = dao.addUser(dto);
        if (result != 1) {
            // ユーザ情報追加に失敗したので、エラー画面に遷移
            return "/html/systemerror.html";
        }
        HttpSession session = req.getSession(false);
        // 次のJSPで表示するため、DBに渡したDTOをセッションに格納する
        // 採番された新たなユーザコードはDAOによって書き換えられている
        session.setAttribute("emp_dto", dto);

        return "/page/userAddComplete.jsp";
    }
}
