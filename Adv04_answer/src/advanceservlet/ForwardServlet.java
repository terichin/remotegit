package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			// 遷移先へのリクエストディスパッチャーを取得します
			RequestDispatcher rd = req.getRequestDispatcher("/page/Hello.jsp");
			// リクエストディスパッチャーを使用して遷移します
			rd.forward(req, res);
		}
	}