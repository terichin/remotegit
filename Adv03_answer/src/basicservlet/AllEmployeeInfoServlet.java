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
import dao.EmployeeInfoDAO;
import dto.EmployeeInfoDTO;

@WebServlet("/allemployeeinfo")

public class AllEmployeeInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			EmployeeInfoDAO dao = new EmployeeInfoDAO();
			// DAOから複数のDTOオブジェクトを取得します
			ArrayList<EmployeeInfoDTO> list = dao.getAllEmployeeInfo();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>AllEmployeeInfoServlet</title></head>");
			out.println("<body>");
			out.println("<table border=\"1\">");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>氏名</th>");
			out.println("<th>パスワード</th>");
			out.println("<th>内線番号</th>");
			out.println("<th>携帯番号</th>");
			out.println("</tr>");
			// 取得したオブジェクト全てを表示します
			for (int i = 0; i < list.size(); i++) {
				EmployeeInfoDTO dto = list.get(i);
				out.println("<tr>");
				out.println("<td>" + dto.getId() + "</td>");
				out.println("<td>" + dto.getUserName() + "</td>");
				out.println("<td>" + dto.getPassword() + "</td>");
				out.println("<td>" + dto.getExtension() + "</td>");
				out.println("<td>" + dto.getMobile() + "</td>");
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
			out.println("<head><title>AllEmployeeInfoServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("従業員情報の取得に失敗しました。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}	
}