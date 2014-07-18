package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculationInput3
 */
@WebServlet("/calculation3")
public class CalculationServlet3 extends HttpServlet {
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		String strNum1 = req.getParameter("NUM1");
		String strNum2 = req.getParameter("NUM2");
		String operator = req.getParameter("OPERATOR");
		try {
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			int result = 0;
			if (operator.equals("1")) {
				result = num1 + num2;
			} else if (operator.equals("2")) {
				result = num1 - num2;
			} else if (operator.equals("3")) {
				result = num1 * num2;
			} else if (operator.equals("4")) {
				result = num1 / num2;
			}
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet3</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("Œ‹‰Ê‚Í" + result + "‚Å‚·B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet3</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("“ü—Í€–Ú‚É‚Í®”‚ğ“ü‚ê‚Ä‚­‚¾‚³‚¢B");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}