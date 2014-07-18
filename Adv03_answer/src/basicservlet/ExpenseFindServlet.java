package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.NewExpenseDAO;

/**
 * Servlet implementation class ExpenseFindServlet
 */
@WebServlet("/expensefind")
public class ExpenseFindServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strId = req.getParameter("ID");
		String strDate = req.getParameter("DATE");
		try {
			NewExpenseDAO dao = new NewExpenseDAO();
			int id = Integer.parseInt(strId);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(strDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			int count = dao.getCost(id, sqlDate);
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseFindServlet</title></head>");
			out.println("<body>");
			out.println("経費の合計は" + count + "円です。");
			out.println("</body>");
			out.println("</html>");
			out.close();				
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseFindServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("IDには整数を入力してください。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		} catch (ParseException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseFindServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("日付の形式が不正です。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		} catch (DAOException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseFindServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("DBアクセスでエラーが発生しました。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}