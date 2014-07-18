package control.action;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.EmployeeDTO;

public class UserUpdateSearchAction implements Action {
    private int empId;            // ユーザコード

    /*
     * 機　能：　入力情報チェックメソッド。
     *
     * 引　数：　リクエストオブジェクト。
     * 戻り値：　入力値が正しい形式であればtrue、それ以外はfalseを返す。
     * 解　説：　入力されるユーザコードに対してnullチェックと数値チェックを行う。
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
        return true;
    }

    /*
     * 機　能：　指定されたユーザコードのユーザ情報を取得するメソッド。
     *
     * 引　数：　セッションを取得する必要があるので、HttpServletRequestを受け取る。
     * 戻り値：　ユーザ情報を取得できれば、更新情報入力画面のパスを返す。
     *          ユーザ情報を取得できなければ、エラー画面のパスを返す。
     * 解　説：　入力されたユーザコードを使用してDBMSからユーザ情報を取得する。
     *          ユーザ情報は次画面の表示で使用するためセッションに保存する。
     */
    public String execute(HttpServletRequest req) throws DAOException {
        NewEmployeeDAO dao = new NewEmployeeDAO();
        EmployeeDTO dto = dao.getUser(empId);
        if (dto != null) {
            HttpSession session = req.getSession(false);
            session.setAttribute("emp_dto", dto);
            return "/page/userUpdateSearchResult.jsp";
        } else {
            return "/html/checkerror.html";
        }
    }
}