package advanceservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/accesscountwrg")
public class AccessCountWrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// HttpServletを継承したクラスにメンバを定義する
	private int count = 0;	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			req.setCharacterEncoding("Windows-31J");
			res.setContentType("text/html; charset=Windows-31J");
			PrintWriter out = res.getWriter();
			out.println("アクセス回数は、" + addCount() + "回です。");
			out.close();
		}
	public int addCount(){
		try{
			count ++;
			Thread.sleep(5000);
			return count;
		}catch(InterruptedException e){
			e.printStackTrace();
			return 0;
		}
	}
}
