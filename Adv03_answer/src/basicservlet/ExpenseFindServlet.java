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
			out.println("�o��̍��v��" + count + "�~�ł��B");
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
			out.println("ID�ɂ͐�������͂��Ă��������B");
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
			out.println("���t�̌`�����s���ł��B");
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
			out.println("DB�A�N�Z�X�ŃG���[���������܂����B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}