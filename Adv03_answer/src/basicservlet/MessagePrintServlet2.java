package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessagePrintServlet2
 */
@WebServlet("/messageprint2")
//ブラウザから氏名を受け取って表示するプログラム
public class MessagePrintServlet2 extends HttpServlet {
	// formからデータを受け取る場合はdoPostをオーバーライドします
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		// 入力パラメータの日本語コードをWindows-31Jに設定します
		req.setCharacterEncoding("Windows-31J");
		// 入力パラメータを取得し、変数に保存します
		String firstName = req.getParameter("FIRSTNAME");
		String lastName = req.getParameter("LASTNAME");
		res.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>MessagePrintServlet2</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// 保存した変数の値を表示します
		out.println("こんにちは、" + lastName + " " + firstName + "さん。");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}
