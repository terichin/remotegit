package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.NewEmployeeDAO;

//IDを受け取り、受け取ったIDに紐づく氏名を表示するプログラム
@WebServlet("/namefind")
public class NameFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.setCharacterEncoding("Windows-31J");
			int id = -1;
			try {
				id = Integer.parseInt(req.getParameter("USERID"));	
				// DAOを使用してDBから値を取得する
				NewEmployeeDAO dao = new NewEmployeeDAO();
				String name = null;
				try {
					name = dao.getName(id);
				} catch (DAOException e) {
					// エラー発生(取得失敗)
					e.printStackTrace();
				}
				res.setContentType("text/html; charset=Windows-31J");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head><title>NameFindServlet</title></head>");
				out.println("<body>");
				out.println("<h2>");
				// DBから値を取得できた場合の処理
				if (name != null) {
					out.println("ID" + id + "の氏名は" + name + "です。");
				// DBから値を取得できなかった場合の処理
				} else {
					out.println("指定のIDが見つかりません。");
				}
				out.println("</h2>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			// ID入力項目に数値以外の値が入力された場合の処理
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// エラー画面を表示します
				res.setContentType("text/html; charset=Windows-31J");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head><title>NameFindServlet</title></head>");
				out.println("<body>");
				out.println("<h2>");
				out.println("IDには数値を入力してください。");
				out.println("</h2>");
				out.println("</body>");
				out.println("</html>");
				out.close();		
			}
		}
	}