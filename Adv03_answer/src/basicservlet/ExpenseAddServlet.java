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

			// DAO���g�p����DB����l���擾����
			NewExpenseDAO dao = new NewExpenseDAO();
			int result = 0;
			try {
				result = dao.add(exid, id, sqlDate, use, cost);
			} catch (DAOException e) {
				// �G���[����(�擾���s)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>ExpenseAddServlet</title></head>");
			out.println("<body>");
			// DB����l���擾�ł����ꍇ�̏���
			if (result == 1) {
				out.println("<h2>�f�[�^�̑}���ɐ������܂����B</h2>");
			// DB����l���擾�ł��Ȃ������ꍇ�̏���
			} else {
				out.println("<h2>�f�[�^�̑}���Ɏ��s���܂����B</h2>");
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
			out.println("�o��ID�AID�A��p�ɂ͐�������͂��Ă��������B");
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
			out.println("���t�̌`�����s���ł��B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}