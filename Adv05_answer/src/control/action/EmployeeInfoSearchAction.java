package control.action;
import java.util.*;
import javax.servlet.http.*;
import control.dao.*;
import control.dto.*;

public class EmployeeInfoSearchAction implements Action {
	private int empId;			// ユーザコード

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
	 * 戻り値：　ユーザ情報を取得できれば、検索結果画面のパスを返す。
	 *           ユーザ情報を取得できなければ、エラー画面のパスを返す。
	 * 解　説：　入力されたユーザ番号を使用してDBMSから複数の情報を取得する。
	 *           ユーザテーブル、電話番号テーブル、部署テーブルから指定のユーザコードに
	 *           対応する情報を取得する。更にユーザ情報の中の上司IDのユーザ情報を
	 *           取得する。これらはそれぞれ対応するDTOオブジェクトに格納し、更に
	 *           それらを1つのArrayListに格納する。ここで作成したArrayListは次画面の
	 *           表示で使用するためセッションに保存する。
	 */
	public String execute(HttpServletRequest req) throws DAOException {
		NewEmployeeDAO empDAO = new NewEmployeeDAO();
		EmployeeDTO empDTO = empDAO.getUser(empId);
		NewContactDAO contactDAO = new NewContactDAO();
		ContactDTO contactDTO = contactDAO.getContact(empId);
		NewPostDAO postDAO = new NewPostDAO();
		PostDTO postDTO = postDAO.getPost(empId);
		// 上司の情報の取得。
		EmployeeDTO bossDTO = empDAO.getUser(postDTO.getBossid());
		ArrayList list = new ArrayList();
		list.add(empDTO);
		list.add(contactDTO);
		list.add(postDTO);
		list.add(bossDTO);
		HttpSession session = req.getSession(false);
		session.setAttribute("emp_list", list);
		return "/page/employeeSearch.jsp";
	}
}