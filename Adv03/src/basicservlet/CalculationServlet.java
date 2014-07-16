package basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//2つの数値を受け取り、足し算の結果を表示するプログラム
@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req,	HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		// 2つの入力値を取得します
		String strNum1 = req.getParameter("NUM1");
		String strNum2 = req.getParameter("NUM2");
		try {
			// 取得した入力値をint型に変換します
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			// 取得した2つのint型の値を加算します
			int total = num1 + num2;
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head><title>CalculationServlet</title></head>");
			out.println("<body>");
			out.println("<h2>");
			// 計算した合計値を表示します
			out.println("合計値は" + total + "です。");
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
			out.println("<head><title>CalculationServlet</title></head>");
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