package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.NewEmployeeDAO;
import dto.EmployeeDTO;

@WebServlet("/allemployeefind")
public class AllEmployeeFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			NewEmployeeDAO dao = new NewEmployeeDAO();
			// DAO���畡����DTO�I�u�W�F�N�g���擾���܂�
			ArrayList<EmployeeDTO> list = dao.getAllEmployee();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>AllEmployeeFindServlet</title></head>");
			out.println("<body>");
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>����</th>");
			out.println("<th>�p�X���[�h</th>");
			out.println("</tr>");
			// �擾�����I�u�W�F�N�g�S�Ă�\�����܂�
			for (int i = 0; i < list.size(); i++) {
				EmployeeDTO dto = list.get(i);
				out.println("<tr>");
				out.println("<td>" + dto.getId() + "</td>");
				out.println("<td>" + dto.getName() + "</td>");
				out.println("<td>" + dto.getPassword() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("</body>");
			out.println("</html>");
			out.close();				
		} catch (DAOException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>AllEmployeeFindServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("�]�ƈ����̎擾�Ɏ��s���܂����B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}	
}