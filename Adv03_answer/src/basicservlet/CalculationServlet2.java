package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculationServlet2
 */
@WebServlet("/calculation2")
//金額を受け取り、消費税の金額計算を行うプログラム
public class CalculationServlet2 extends HttpServlet {
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		// 金額を取得します
		String strPrice = req.getParameter("PRICE");
		try {
			// 取得した入力値をint型に変換します
			int price = Integer.parseInt(strPrice);
			// 入力金額の税額を計算します
			int tax = (int) (price * 0.05);
			// 取得した2つのint型の値を加算します
			int total = price + tax;
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet2</title></head>");
			out.println("<body>");
			out.println("<h2>");
			// 計算した合計値を表示します
			out.println("価格は　" + price + "円<br>");
			out.println("税額は　" + tax + "円<br>");
			out.println("合計値は" + total + "円<br>");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		// 入力値を数値に変換できなかった場合の処理
		} catch (NumberFormatException e) {
			// スタックトレースを出力します
			e.printStackTrace();
			// エラー画面を表示します
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet2</title></head>");
			out.println("<body>");
			out.println("<h2>");
			out.println("入力項目には整数を入れてください。");
			out.println("</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
		}
	}
}