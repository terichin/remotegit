package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewPostDAO;
import dao.DAOException;

/**
 * Servlet implementation class PostFindServlet
 */
@WebServlet("/postfind")
public class PostFindServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strId = req.getParameter("POSTID");
		try {
			int id = Integer.parseInt(strId);
			// DAOを使用してDBから値を取得する
			NewPostDAO dao = new NewPostDAO();
			String postName = null;
			try {
				postName = dao.getName(id);
			} catch (DAOException e) {
				// エラー発生(取得失敗)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>PostFindServlet</title></head>");
			out.println("<body>");
			// DBから値を取得できた場合の処理
			if (postName != null) {
				out.println("<h2>部署名は" + postName + "です。</h2>");
			// DBから値を取得できなかった場合の処理
			} else {
				out.println("<h2>指定のIDが見つかりません。</h2>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();				
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>PostFindServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("IDには整数を入力してください。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}