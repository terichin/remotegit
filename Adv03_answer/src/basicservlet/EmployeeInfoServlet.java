package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.EmployeeInfoDAO;
import dto.EmployeeInfoDTO;

/**
 * Servlet implementation class EmployeeInfoServlet
 */
@WebServlet("/employeeinfo")
public class EmployeeInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strId = req.getParameter("ID");
		try {
			int id = Integer.parseInt(strId);
			// DAO���g�p����DB����l��DTO�Ŏ擾����
			EmployeeInfoDAO dao = new EmployeeInfoDAO();
			EmployeeInfoDTO dto = null;
			try {
				dto = dao.getEmployeeInfo(id);
			} catch (DAOException e) {
				// �G���[����(�擾���s)
				e.printStackTrace();
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>EmployeeInfoServlet</title></head>");
			out.println("<body>");
			// DB����l���擾�ł����ꍇ�̏���
			if (dto != null) {
				out.println("<table border=\"1\">");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>����</th>");
				out.println("<th>�p�X���[�h</th>");
				out.println("<th>�����ԍ�</th>");
				out.println("<th>�g�єԍ�</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + dto.getId() + "</td>");
				out.println("<td>" + dto.getUserName() + "</td>");
				out.println("<td>" + dto.getPassword() + "</td>");
				out.println("<td>" + dto.getExtension() + "</td>");
				out.println("<td>" + dto.getMobile() + "</td>");
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
			out.println("<head><title>EmployeeInfoServlet</title></head>");
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