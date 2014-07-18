package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorldTimePrintServlet
 */
@WebServlet("/worldtimeprint")
//Webブラウザに日本標準時と世界標準時の現時刻を表示するプログラム
//サーブレットなので、HttpServletを継承して作ります
public class WorldTimePrintServlet extends HttpServlet {
	// サーブレットで実行することはdoGetをオーバーライドして記述します
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 現時刻の情報を取得します
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int h = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int m = cal.get(java.util.Calendar.MINUTE);
		int s = cal.get(java.util.Calendar.SECOND);
		// 日本標準時の文字列を作成します
		String time_local = h + ":" + m + ":" + s;
		// 世界標準時を求めます
		int wh = h - 9;
		// 時刻がマイナスの時は補正する
		if (wh < 0) {
			wh +=24;
		}
		// 世界標準時の文字列を作成します
		String time_world = wh + ":" + m + ":" + s;
		// 出力する日本語コードをWindows-31Jに設定します
		res.setContentType("text/html; charset=Windows-31J");
		// ブラウザへの出力路を確保します
		PrintWriter out = res.getWriter();
		// ブラウザにHTMLを送ります
		out.println("<html>");
		out.println("<head><title>WorldTimePrintServlet</title></head>");
		out.println("<body>");
		out.println("<h2>");
		// 時刻情報部分には変数(time_localとtime_world)を使用します
		out.println("日本標準時の現在時刻は" + time_local + "です。");
		out.println("<br>");
		out.println("世界標準時の現在時刻は" + time_world + "です。");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		// 出力ストリームを切断します
		out.close();
	}
}
