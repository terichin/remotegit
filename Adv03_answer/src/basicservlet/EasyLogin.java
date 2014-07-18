package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EasyLogin
 */
@WebServlet("/easylogin")
public class EasyLogin extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			String user = req.getParameter("USERID");
			String password = req.getParameter("PASSWORD");
			String message = "ログイン失敗";
			if (user.equals("univ") && password.equals("hanako")) {
				message = "ログインしました";
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>EasyLogin</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println(message);
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
	}
}