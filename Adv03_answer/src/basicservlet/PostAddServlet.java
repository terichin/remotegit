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
 * Servlet implementation class PostAddServlet
 */
@WebServlet("/postadd")
public class PostAddServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strId = req.getParameter("ID");
		String postName = req.getParameter("POSTNAME");
		String strBossID = req.getParameter("BOSSID");
		try {
			int id = Integer.parseInt(strId);
			int bossId = Integer.parseInt(strBossID);
			// DAO���g�p����DB����l���擾����
			NewPostDAO dao = new NewPostDAO();
			int result = 0;
			result = dao.add(id, postName, bossId);
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>PostAddServlet</title></head>");
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
			out.println("<head><title>PostAddServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("ID�A��iID�ɂ͐�������͂��Ă��������B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();	
		} catch (DAOException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>PostAddServlet</title></head>");
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