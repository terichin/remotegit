package advanceservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcservlet")
public class MVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.setCharacterEncoding("Windows-31J");
			// 決まった名前が付けられた入力パラメータを取得します
			String action = req.getParameter("action");
			// 入力パラメータの値によって、次に遷移するページを選びます
			String nextPage = null;
			if (action.equals("page1")) {
				// page1であれば、Hello.jspに遷移します
				nextPage = "/page/Hello.jsp";
			} else if (action.equals("page2")) {
				// page2であれば、MessagePrint.jspに遷移します
				nextPage = "/page/MessagePrint.jsp";
			}
			// 遷移先へのリクエストディスパッチャーを取得し、遷移します
			RequestDispatcher rd = req.getRequestDispatcher(nextPage);
			rd.forward(req, res);
		}
	}