package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ブラウザからの入力を受け取って表示するプログラム
@WebServlet("/messageprint")
public class MessagePrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		// 入力パラメータの日本語コードをWindows-31Jに設定します
		req.setCharacterEncoding("Windows-31J");
		// 入力パラメータを取得し、変数に保存します
		String msg = req.getParameter("MESSAGE");
		res.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>MessagePrintServlet</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// 保存した変数の値を表示します
		out.println("入力したメッセージは「" + msg + "」ですね。");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
}