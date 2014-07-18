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

//ID���󂯎��A�󂯎����ID�ɕR�Â�������\������v���O����
@WebServlet("/namefind")
public class NameFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.setCharacterEncoding("Windows-31J");
			int id = -1;
			try {
				id = Integer.parseInt(req.getParameter("USERID"));	
				// DAO���g�p����DB����l���擾����
				NewEmployeeDAO dao = new NewEmployeeDAO();
				String name = null;
				try {
					name = dao.getName(id);
				} catch (DAOException e) {
					// �G���[����(�擾���s)
					e.printStackTrace();
				}
				res.setContentType("text/html; charset=Windows-31J");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head><title>NameFindServlet</title></head>");
				out.println("<body>");
				out.println("<h2>");
				// DB����l���擾�ł����ꍇ�̏���
				if (name != null) {
					out.println("ID" + id + "�̎�����" + name + "�ł��B");
				// DB����l���擾�ł��Ȃ������ꍇ�̏���
				} else {
					out.println("�w���ID��������܂���B");
				}
				out.println("</h2>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			// ID���͍��ڂɐ��l�ȊO�̒l�����͂��ꂽ�ꍇ�̏���
			} catch (NumberFormatException e) {
				e.printStackTrace();
				// �G���[��ʂ�\�����܂�
				res.setContentType("text/html; charset=Windows-31J");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head><title>NameFindServlet</title></head>");
				out.println("<body>");
				out.println("<h2>");
				out.println("ID�ɂ͐��l����͂��Ă��������B");
				out.println("</h2>");
				out.println("</body>");
				out.println("</html>");
				out.close();		
			}
		}
	}