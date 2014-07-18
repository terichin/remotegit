package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculationDays
 */
@WebServlet("/calcdays")
public class CalculationDays extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_YEAR);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		int dayCount = lastDay - today;
		
		res.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>CalculationDays</title></head>");
		out.println("<body>");
		out.println("<h2>");
		out.println("ç°îNÇÕÇ†Ç∆" + dayCount + "ì˙Ç≈Ç∑ÅB");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
