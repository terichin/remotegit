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

import dao.NewExpenseDAO;
import dao.DAOException;

/**
 * Servlet implementation class ExpenseAddServlet
 */
@WebServlet("/expenseadd")
public class ExpenseAddServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strExId = req.getParameter("EXID");
		String strId = req.getParameter("ID");
		String strDate = req.getParameter("DATE");
		String strUse = req.getParameter("USE");
		String strCOST = req.getParameter("COST");
		try {
			int exid = Integer.parseInt(strExId);
			int id = Integer.parseInt(strId);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(strDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String use = strUse;
			int cost = Integer.parseInt(strCOST);

			// DAOを使用してDBから値を取得する
			NewExpenseDAO dao = new NewExpenseDAO();
			int result = 0;
			try {
				result = dao.add(exid, id, sqlDate, use, cost);
			} catch (DAOException e) {
				// エラー発生(取得失敗)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseAddServlet</title></head>");
			out.println("<body>");
			// DBから値を取得できた場合の処理
			if (result == 1) {
				out.println("<h2>データの挿入に成功しました。</h2>");
			// DBから値を取得できなかった場合の処理
			} else {
				out.println("<h2>データの挿入に失敗しました。</h2>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();				
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseAddServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("経費ID、ID、費用には整数を入力してください。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		} catch (ParseException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseAddServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("日付の形式が不正です。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}