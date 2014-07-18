package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class UserUpdateAction implements Action {
    private int empId;          // ユーザコード
    private String name;        // 名前
    private String password;    // パスワード

    /*
     * 機　能：　入力情報チェックメソッド。
     *
     * 引　数：　リクエストオブジェクト。
     * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
     * 解　説：　入力されたユーザ情報の各編集内容をチェックする。
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
        // 名前のチェック
        name = req.getParameter("name");
        if ((name == null) || ("".equals(name) == true)) {
            return false;
        }
        // パスワードのチェック
        password = req.getParameter("password");
        if ((password == null) || ("".equals(password) == true)) {
            return false;
        }
        return true;
    }

    /*
     * 機　能：　ユーザ情報の更新を実行するメソッド。
     *
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     * 戻り値：　ユーザ情報更新に成功した場合は、ユーザ情報編集完了画面のパスを返す。
     *           ユーザ情報更新に失敗した場合は、エラー画面のパスを返す。
     * 解　説：　入力されたパラメータを使用してDTOオブジェクトを生成し、
     *           EmployeeDAOのメソッドにDTOを渡してユーザ情報を更新する。
     *           更新に使用した情報は次画面で必要となるためセッションに保存し、
     *           ユーザ情報編集完了画面に遷移する。
     */
    public String execute(HttpServletRequest req) throws DAOException {
        EmployeeDTO dto = new EmployeeDTO(empId, name, password);
        NewEmployeeDAO dao = new NewEmployeeDAO();
        int result = dao.updateUser(dto);
        if (result != 1) {
            return "/html/systemerror.html";
        }
        HttpSession session = req.getSession(false);
        session.setAttribute("emp_dto", dto);

        return "/page/userUpdateComplete.jsp";
    }
}