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
import dto.EmployeeDTO;

@WebServlet("/employeefind")
public class EmployeeFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strId = req.getParameter("USERID");
		try {
			int id = Integer.parseInt(strId);
			// DAO���g�p����DB����l��DTO�Ŏ擾����
			NewEmployeeDAO dao = new NewEmployeeDAO();
			EmployeeDTO dto = null;
			try {
				dto = dao.getEmployee(id);
			} catch (DAOException e) {
				// �G���[����(�擾���s)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>EmployeeFindServlet</title></head>");
			out.println("<body>");
			// DB����l���擾�ł����ꍇ�̏���
			if (dto != null) {
				out.println("<table border=\"1\">");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>����</th>");
				out.println("<th>�p�X���[�h</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + dto.getId() + "</td>");
				out.println("<td>" + dto.getName() + "</td>");
				out.println("<td>" + dto.getPassword() + "</td>");
				out.println("</tr>");
				out.println("</table>");
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
			out.println("<head><title>NameFindServlet</title></head>");
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