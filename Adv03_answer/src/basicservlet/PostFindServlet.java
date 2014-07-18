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
			// DAO���g�p����DB����l���擾����
			NewPostDAO dao = new NewPostDAO();
			String postName = null;
			try {
				postName = dao.getName(id);
			} catch (DAOException e) {
				// �G���[����(�擾���s)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>PostFindServlet</title></head>");
			out.println("<body>");
			// DB����l���擾�ł����ꍇ�̏���
			if (postName != null) {
				out.println("<h2>��������" + postName + "�ł��B</h2>");
			// DB����l���擾�ł��Ȃ������ꍇ�̏���
			} else {
				out.println("<h2>�w���ID��������܂���B</h2>");
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
			out.println("ID�ɂ͐�������͂��Ă��������B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}