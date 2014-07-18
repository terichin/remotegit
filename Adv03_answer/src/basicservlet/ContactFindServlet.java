package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.NewContactDAO;
import dto.ContactDTO;

/**
 * Servlet implementation class ContactFindServlet
 */
@WebServlet("/contactfind")
public class ContactFindServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strId = req.getParameter("CONTACTID");
		try {
			int id = Integer.parseInt(strId);
			// DAOを使用してDBから値をDTOで取得する
			NewContactDAO dao = new NewContactDAO();
			ContactDTO dto = null;
			try {
				dto = dao.getContact(id);
			} catch (DAOException e) {
				// エラー発生(取得失敗)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ContactFindServlet</title></head>");
			out.println("<body>");
			// DBから値を取得できた場合の処理
			if (dto != null) {
				out.println("<table border=\"1\">");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>内線番号</th>");
				out.println("<th>携帯番号</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + dto.getId() + "</td>");
				out.println("<td>" + dto.getExtension() + "</td>");
				out.println("<td>" + dto.getMobile() + "</td>");
				out.println("</tr>");
				out.println("</table>");
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
			out.println("<head><title>ContactFindServlet</title></head>");
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