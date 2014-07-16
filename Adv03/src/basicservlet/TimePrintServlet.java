package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Webブラウザに現時刻を表示するプログラム
//サーブレットなので、HttpServletを継承して作ります
@WebServlet("/timeprint")
public class TimePrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// サーブレットで実行することはdoGetをオーバーライドして記述します
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 現時刻の情報を取得します
		Date date = new Date();
		// 出力する日本語コードをWindows-31Jに設定します
		res.setContentType("text/html; charset=Windows-31J");
		// ブラウザへの出力ストリームを確保します
		PrintWriter out = res.getWriter();
		// ブラウザにHTMLを送ります
		out.println("<html>");
		out.println("<head><title>TimePrintServlet</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// 時刻情報部分には変数(date)を使用します
		out.println("現在の時刻は" + date + "です。");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		// 出力ストリームを切断します
		out.close();
	}

}
